package com.tedu.wxadmin.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.service.IWishService;

@Controller
public class WishController {
	@Autowired
	IWishService wishService;
	@RequestMapping("savewish")
	@ResponseBody
	public boolean savewish(String userno,String quesno,String source) {
		int quesid = Integer.parseInt(quesno);	
		boolean reg = wishService.savewish(userno,quesid,source);
		return reg;

	}
	@RequestMapping("deletewish")
	@ResponseBody
	public boolean deletewish(String userno,String quesno,String source) {
		int quesid = Integer.parseInt(quesno);
		boolean reg = wishService.deletewish(userno,quesid,source);
		return reg;
	}
	
	@RequestMapping("findwish")
	@ResponseBody
	public int findwish(String userno,String id,String source) {
		int quesid = Integer.parseInt(id);
		int res = wishService.findwish(userno,quesid,source);
		return res;
	}
	
}
