package com.tedu.wxadmin.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.QUESResult;
import com.tedu.wxadmin.model.part;
import com.tedu.wxadmin.model.partdetail;
import com.tedu.wxadmin.service.IPartService;

@Controller
@RequestMapping("partpages")
public class PDetailController {
	@Autowired
	IPartService partService;
	@RequestMapping("pdetail")
	public String question() {
		System.out.println("detail");
		return "partpages/pdetail";
	}
	
	@RequestMapping("uploadpart")//发布真题页面
	public String uploadques() {
		System.out.println("上传文件");
		return "partpages/uploadpart";
	}
	// 批量添加数据
    @PostMapping("/upload")
    @ResponseBody
    //@RequestMapping("/upload")
    public Map<String,String> upload(MultipartFile excelFile) throws Exception{
        Map<String,String> map = new HashMap<>();
        if (excelFile.isEmpty()){
            map.put("mag","文件夹为空，重新上传");
            return map;
        }else {
            String fileName = excelFile.getOriginalFilename();
            InputStream is = excelFile.getInputStream();
            if (partService.importPartInfo(fileName,is)){
                map.put("msg","数据添加成功");
                return map;
            }else {
                map.put("msg","数据添加失败，请重新添加");
                return map;
            }
        }
    }
    @RequestMapping("adddetail")
    public String adddetail(Model model) {
    	List<part> list = partService.queryList();//查询所有现有的真题
    	model.addAttribute("plist", list);
    	return "partpages/adddetail";
    }
    @RequestMapping("updatedetail")
    public String updateissue(Model model,int id) {
    	partdetail pd = partService.findByPid(id);//根据id寻找相应的题目,显示在页面中
    	model.addAttribute("pd", pd);
    	return "partpages/updatedetail";//更新页面
    }
    
    @RequestMapping("savedetail")
	@ResponseBody
	public QUESResult save(partdetail pd) {//保存题目
    	QUESResult result = new QUESResult();
    	if(pd.getId()==0) {
    		partService.insertdetail(pd);//新增
    		//System.out.println(pd);
    	}else {
    		partService.updatedetail(pd);//更新
    	}
    	return result;
    }
    @RequestMapping("deleteissue")
    @ResponseBody
    public QUESResult deleteissue(int id) {//根据id删除
		QUESResult result = new QUESResult();
		partService.deleteissue(id);
		return result;
    }
	
	@RequestMapping("detailList")
	//把模型转为Json数据
	/*page：显示的当前页
	 * limit:每次显示多少条*/
	@ResponseBody
	public PageResult<partdetail> listJson(int page,int limit){//真题题目列表
		PageResult<partdetail> result = partService.findDPageResult(null,page,limit);//limit即pagesize	 
		return result;
	}
	/****************************************小程序*********************************************/
	@RequestMapping("finddetail")
	@ResponseBody
	public PageResult<partdetail> finddetail(String partno){//根据partno查询每个年份的真题
		int pno = Integer.parseInt(partno);
		PageResult<partdetail> result = partService.finddetail(pno);
		return result;
		
	}
	@RequestMapping("showwrong")
	@ResponseBody
	public PageResult<partdetail> showwrong(String userno){
		PageResult<partdetail> result = partService.showwrong(userno);
		return result;
	}
	
	@RequestMapping("showexamwish")
	@ResponseBody
	public PageResult<partdetail> showexamwish(String userno,String source){//查询某一用户收藏的题目
		PageResult<partdetail> result = partService.showexamwish(userno,source);//收藏夹
		return result;
	}
}
