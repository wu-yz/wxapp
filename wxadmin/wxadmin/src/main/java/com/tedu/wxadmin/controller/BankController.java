package com.tedu.wxadmin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.wxadmin.model.QUESResult;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.banklist;
import com.tedu.wxadmin.service.IBankService;

@Controller
@RequestMapping("bankpages")
public class BankController {
	@Autowired
	IBankService bankService;
	@RequestMapping("bank")
	public String bank() {
		System.out.println("hhh");
		return "bankpages/bank";
	}
	//增加题库
	@RequestMapping("addbank")
	public String addbank() {
		return "bankpages/addbank";
	}
	
	//修改题库信息
	@RequestMapping("updatebank")
	public String updatebank(Model model,int id) {
		//System.out.println("修改题库信息id="+id);
		banklist b = bankService.findByBankId(id);
		model.addAttribute("b",b);
		return "bankpages/updatebank";
	}
	
//	@RequestMapping("detail")
//	public String detail() {
//		return "bankpages/detail";
//	}
	@RequestMapping("delete")//删除
	@ResponseBody
	public QUESResult delete(int id) {
		//int bno = Integer.parseInt(id);
		QUESResult result = new QUESResult();
		bankService.deleteByBid(id);
		return result;
	}
	
	@RequestMapping("save")
	@ResponseBody
	//返回结果
	public QUESResult save(banklist list) {
		QUESResult result = new QUESResult();
		if(list.getBankno()==0) {
			bankService.save(list);
		}else {
			bankService.update(list);
		}
		
		System.out.println(list);
		
		return result;
	}
	
	
	@RequestMapping("listJson")
	//把模型转为Json数据
	/*page：显示的当前页
	 * limit:每次显示多少条*/
	@ResponseBody
	public PageResult<banklist> listJson(int page,int limit){
		PageResult<banklist> result = bankService.findPageResult(null,page,limit);//limit即pagesize	
		
		//result.setData(list); 
		return result;
	}
	
	
	/*
	 * 前端操作
	 * 
	 * */
	
}
