package com.tedu.wxadmin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.wxadmin.mapper.BankMapper;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.banklist;
import com.tedu.wxadmin.service.IBankService;
@Service
public class IBankServiceImpl implements IBankService{
	@Autowired
	BankMapper bmapper;
	@Override
	public PageResult<banklist> findPageResult(banklist condition, int page,int pagesize) {//题库页面数据
		PageResult<banklist> result = new PageResult<banklist>();
		result.setCode(0);
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
        //select * from bank limit 0,10
		parmas.put("start", (page-1)*pagesize);
		parmas.put("pageSize", pagesize);
		//获取总记录数据
		int totalCount=bmapper.findCountByMap(parmas);
		result.setCount(totalCount);
		//获取查询数据
		List<banklist> list=bmapper.findBankListByMap(parmas);		
		result.setData(list); 
		return result;
	}
	@Override
	public void save(banklist list) {//实现新增方法
		bmapper.insert(list);
	}
	@Override
	public void deleteByBid(int id) {//实现删除方法
		bmapper.deleteByBid(id);
		
	}
	@Override
	public banklist findByBankId(int id) {//根据id查题库
		return bmapper.findByBankId(id);
	}
	@Override
	public void update(banklist list) {//更新
		bmapper.update(list); 
		
	}
	@Override
	public List<banklist> nameList() {//题目详情实现在下拉框显示科目名称
		return bmapper.nameList();
	}

}
