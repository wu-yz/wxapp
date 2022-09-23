package com.tedu.wxadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.video;
@Mapper
public interface VideoMapper {

	public int findVideoCount();//获取总体数据

	public List<video> findVideoList();//查询视频信息

	public void deleteByVid(int id);//根据id删除

	public video findVideoById(int vid);//根据id查询

	public void insertvideo(video list);//插入数据

	public void updatevideo(video list);//修改数据

	public String findaddbyvid(int vid);//根据id查地址
	
}
