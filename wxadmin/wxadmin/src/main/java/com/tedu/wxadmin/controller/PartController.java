package com.tedu.wxadmin.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.QUESResult;
import com.tedu.wxadmin.model.part;
import com.tedu.wxadmin.service.IPartService;

@Controller
@RequestMapping("partpages")
public class PartController {
	@Autowired
	IPartService partService;
	@RequestMapping("part")//主页面的显示
	public String part() {
		System.out.println("part");
		return "partpages/part";
	}
	
	@RequestMapping("addpart")//添加页面的显示
	public String addpart() {
		System.out.println("addpart");
		return "partpages/addpart";
	}
	
	@RequestMapping("updatepart")//编辑页面的显示
	public String updatepart(Model model,int pid) {
		part p = partService.findPartById(pid);
		model.addAttribute("part",p);
		System.out.println("updatepart");
		return "partpages/updatepart";
	}
	
	
	@RequestMapping("listJson")
	//把模型转为Json数据
	/*page：显示的当前页
	 * limit:每次显示多少条*/
	@ResponseBody
	public PageResult<part> listJson(int page,int limit){
		PageResult<part> result = partService.findPageResult(null,page,limit);//limit即pagesize	 
		return result;
	}
	@RequestMapping("save")
	@ResponseBody
	//返回结果，保存
	public QUESResult save(part p) {
		QUESResult result = new QUESResult();
		if(p.getPartNo()==0) {//若题集号为0，则进行新增操作
			partService.insert(p);
		}else {
			partService.update(p);//否则，是更新
		}
		System.out.println(p);
		return result;
	}
	@RequestMapping("delete")
	@ResponseBody
	public QUESResult delete(int pid) {
		QUESResult result = new QUESResult();
		partService.delete(pid);
		return result;
	}
	
	/*
	 * 
	 * 前端操作
	 * 
	 * */
	
	// 真题信息
    //@PostMapping("/part")
    @RequestMapping("showpart")
    @ResponseBody
    public PageResult showpart(){
    	PageResult<part> result = partService.findPartResult();
    	System.out.println(result);
    	return result;
    }
}
