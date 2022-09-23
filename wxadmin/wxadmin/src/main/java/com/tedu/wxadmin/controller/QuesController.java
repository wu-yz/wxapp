package com.tedu.wxadmin.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.QUESResult;
import com.tedu.wxadmin.model.banklist;
import com.tedu.wxadmin.model.question;
import com.tedu.wxadmin.service.IBankService;
import com.tedu.wxadmin.service.IQuesService;
@Controller
@RequestMapping("questionpages")
public class QuesController {
	@Autowired
	IQuesService quesService;
	@Autowired
	IBankService bankService;
	@RequestMapping("question")
	public String question() {//题集首页
		System.out.println("hhh");
		return "questionpages/question";
	}
	
	@RequestMapping("uploadques")
	public String uploadques() {//上传页面
		System.out.println("上传文件");
		return "questionpages/uploadques";
	}
	
	// 批量添加数据
    @PostMapping("/upload")//上传页面
    @ResponseBody
    //@RequestMapping("/upload")
    public Map<String,String> upload(MultipartFile excelFile) throws Exception{
        Map<String,String> map = new HashMap<>();
        if (excelFile.isEmpty()){
            map.put("mag","文件夹为空，重新上传");
            return map;
        }else {
            String fileName = excelFile.getOriginalFilename();//获得导入的表名
            InputStream is = excelFile.getInputStream();//导入的表的输入流
            if (quesService.importQuesInfo(fileName,is)){//调用Service层
                map.put("msg","数据添加成功");
                return map;
            }else {
                map.put("msg","数据添加失败，请重新添加");
                return map;
            }
        }
    }
    //删除题目信息
    @RequestMapping("deleteques")//删除
	@ResponseBody
	public QUESResult delete(int qno) {
		//int bno = Integer.parseInt(id);
		QUESResult result = new QUESResult();
		quesService.deleteByQid(qno);
		return result;
	}
	
	
	//修改题目信息
	@RequestMapping("updateques")
	public String updateques(Model model,int qno) {
		//System.out.println("修改题库信息id="+id);
		question q = quesService.findByQid(qno);
		model.addAttribute("q",q);
		//String bname = 
		//List<banklist> blist = bankService.nameList();
		//model.addAttribute("blist",blist);
		return "questionpages/updateques";
	}
		//增加题目
		@RequestMapping("addques")
		public String addbank(Model model) {
			List<banklist> blist=bankService.nameList();
			model.addAttribute("blist",blist);
			return "questionpages/addques";
		}
		@RequestMapping("save")
		@ResponseBody
		//返回结果
		public QUESResult save(question q) {
			QUESResult result = new QUESResult();
			if(q.getQuesNo()==0) {
				quesService.save(q);
			}else {
				quesService.update(q);
			}
			
			System.out.println(q);
			
			return result;
		}
		
	@RequestMapping("Queslist")
	//把模型转为Json数据
	/*page：显示的当前页
	 * limit:每次显示多少条*/
	@ResponseBody
	public PageResult<question> Queslist(question condition,int page,int limit){
		//System.out.println(condition);
		PageResult<question> result = quesService.findPageResult(condition,page,limit);//limit即pagesize	 
		return result;
	}
	
	/*******************************************小程序*************************************/
	@RequestMapping("findchapter")//返回章节名称
	@ResponseBody
	public PageResult findchapter(String bankno) {
		int bno = Integer.parseInt(bankno);
		PageResult result = quesService.findchapter(bno);
		return result;
	}
	
	@RequestMapping("quesBychapter")//根据章节名称以及bankid查题目
	@ResponseBody
	public PageResult<question> quesBychapter(String bankno,String chapter){
		int bankid = Integer.parseInt(bankno);
		PageResult<question> qresult = quesService.quesByChapId(bankid,chapter);
		return qresult;
	}
	/******查询错题*****/
	@RequestMapping("showwrong")
	@ResponseBody
	public PageResult<question> showwrong(String userno){
		//int bankid = Integer.parseInt(bankno);
		PageResult<question> qresult = quesService.showwrong(userno);
		return qresult;
	}
	@RequestMapping("showtestwish")
	@ResponseBody
	public PageResult<question> showtestwish(String userno,String source){//显示收藏夹
		PageResult<question> qresult = quesService.showtestwish(userno,source);
		return qresult;
	}
	
}
