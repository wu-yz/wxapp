package com.tedu.wxadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.QUESResult;
import com.tedu.wxadmin.model.video;
import com.tedu.wxadmin.service.IVideoService;

@Controller
@RequestMapping("videopages")
public class VideoController {
	@Autowired
	IVideoService videoService;
	@RequestMapping("video")
	public String video() {//页面跳转
		System.out.println("video");
		return "videopages/video";
	}
	@RequestMapping("addvideo")
	public String addvideo() {//页面跳转
		System.out.println("addvideo");
		return "videopages/addvideo";
	}
	
	
	@RequestMapping("videolist")
	//把模型转为Json数据
	@ResponseBody
	public PageResult<video> videolist(){//显示页面数据、前端也用了这个方法
		PageResult<video> vlist = videoService.findVideoList();
		return vlist;
	}
	
	@RequestMapping("delete")//删除
	@ResponseBody
	public QUESResult delete(int id) {
		QUESResult result = new QUESResult();
		videoService.deleteByVid(id);
		return result;
	}
	@RequestMapping("updatevideo")
	public String updatevideo(Model model,int id) {
		video v = videoService.findVideoById(id);//寻找指定id的对象 显示到页面中
		model.addAttribute("vi",v);
		return "videopages/updatevideo";//跳转到修改页面~
	}
	@RequestMapping("save")
	@ResponseBody
	//返回结果
	public QUESResult save(video list) {
		QUESResult result = new QUESResult();
		if(list.getVid()==0) {//如果vid=0,那么就是添加新的数据
			videoService.save(list);
		}else {
			videoService.update(list);//不等于0，是修改
		}
		System.out.println(list);		
		return result;
	}
	/***********************/
	@RequestMapping("findbyvid")
	@ResponseBody
	public String findbyvid(String vid){//显示页面数据、前端也用了这个方法
		int id = Integer.parseInt(vid); 
		String addr = videoService.findbyvid(id);
		return addr;
	}
	
}
