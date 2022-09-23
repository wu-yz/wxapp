package com.tedu.wxadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
