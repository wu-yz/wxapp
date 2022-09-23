package com.tedu.wxadmin.service;

import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.video;

public interface IVideoService {

	public PageResult<video> findVideoList();//显示视频信息

	public void deleteByVid(int id);//根据id删除
	
	public video findVideoById(int vid);//根据id查询

	public void save(video list);//保存新添加的数据

	public void update(video list);//更新数据

	/************前端***********/
	
	public String findbyvid(int vid);//查询视频
	
	
	
}
