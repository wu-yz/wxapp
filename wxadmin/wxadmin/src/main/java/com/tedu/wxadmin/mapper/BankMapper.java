package com.tedu.wxadmin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tedu.wxadmin.model.banklist;
@Mapper
public interface BankMapper {
	public int findCountByMap(Map<String,Object> map);
	
	public List<banklist> findBankListByMap(Map<String,Object> map);
	
	public void insert(banklist list);//新增
	
	public void deleteByBid(int id);//根据id删除
	
	public banklist findByBankId(int id);//根据id查找
	
	public void update(banklist list);//更新一下

	public List<banklist> nameList();//下拉框显示
}
