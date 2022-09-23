package com.tedu.wxadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.wxadmin.model.Testwrong;
import com.tedu.wxadmin.service.IWrongService;

@Controller
public class WrongController {
	@Autowired
	IWrongService wrongService;
	@RequestMapping("addwrong")
	@ResponseBody
	public boolean addwrong(String userno,String qno,String select) {
		int quesno = Integer.parseInt(qno);
		Testwrong twrong = new Testwrong();
		twrong.setQuesno(quesno);
		twrong.setSelected(select);
		twrong.setUno(userno);
		boolean res = wrongService.add(twrong);
		return res;
	}
	
	
	//****下面是真题的错题操作****//
	@RequestMapping("addexamWrong")
	@ResponseBody
	public boolean addexamWrong(String userno,String id,String select) {
		int issue_id = Integer.parseInt(id);
		boolean res = wrongService.addexamWrong(userno,issue_id,select);
		return res;
	}
	
}
