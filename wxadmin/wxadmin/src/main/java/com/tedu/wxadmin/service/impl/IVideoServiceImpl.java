package com.tedu.wxadmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.wxadmin.mapper.VideoMapper;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.video;
import com.tedu.wxadmin.service.IVideoService;
@Service
public class IVideoServiceImpl implements IVideoService {
	@Autowired
	VideoMapper vmapper;
	@Override
	public PageResult<video> findVideoList() {//视频数据
		PageResult<video> result = new PageResult<video>();
		result.setCode(0);
		//获取总记录数据
		int totalCount=vmapper.findVideoCount();
		result.setCount(totalCount);
		//获取查询数据
		List<video> list=vmapper.findVideoList();
		result.setData(list); 
		return result;
	}
	@Override
	public void deleteByVid(int id) {//根据id删除实现方法
		vmapper.deleteByVid(id);
		
	}
	@Override
	public video findVideoById(int vid) {//根据id查询实现方法
		// TODO Auto-generated method stub
		return vmapper.findVideoById(vid);
	}
	@Override
	public void save(video list) {//新增数据
		vmapper.insertvideo(list);
		
	}
	@Override
	public void update(video list) {//修改数据
		vmapper.updatevideo(list);
		
	}
	
	/*****************************/
	@Override
	public String findbyvid(int vid) {//根据id查询视频信息
		//获取查询数据
		String addr=vmapper.findaddbyvid(vid);
		return addr;
	}

}
