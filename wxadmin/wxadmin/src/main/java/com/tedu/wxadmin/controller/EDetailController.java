package com.tedu.wxadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.examdetail;
import com.tedu.wxadmin.service.IExamService;

@Controller
public class EDetailController {
	@Autowired
	IExamService eService;
	@RequestMapping("addexamdetail")
	@ResponseBody
	public boolean addexamdetail(String uno,String examname,String num) {
		int rightnum = Integer.parseInt(num);
		boolean res = eService.addexamdetail(uno,examname,rightnum);
		return res;
	}
	
	@RequestMapping("showrecord")
	@ResponseBody
	public PageResult<examdetail> showrecord(String uno) {
		PageResult<examdetail> res = eService.findAllByUno(uno);
		return res;
	}
}
