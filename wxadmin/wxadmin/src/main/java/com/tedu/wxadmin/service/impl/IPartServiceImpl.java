package com.tedu.wxadmin.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.wxadmin.mapper.PartMapper;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.part;
import com.tedu.wxadmin.model.partdetail;
import com.tedu.wxadmin.service.IPartService;
import com.tedu.wxadmin.utils.ImportExcelUtils;

@Service
public class IPartServiceImpl implements IPartService{
	@Autowired
	PartMapper pmapper;
	@Resource
	ImportExcelUtils excelUtils;
	/***********真题集**********/
	@Override
	public PageResult<part> findPageResult(Object object, int page, int pagesize) {//真题页
		PageResult<part> result = new PageResult<part>();
		result.setCode(0);
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
        //select * from bank limit 0,10
		parmas.put("start", (page-1)*pagesize);
		parmas.put("pageSize", pagesize);
		//获取总记录数据
		int totalCount=pmapper.findCountByMap(parmas);
		result.setCount(totalCount);
		//获取查询数据
		List<part> list=pmapper.findPartByMap(parmas);
		
		
		result.setData(list); 
		return result;
	}
	@Override
	public void insert(part p) {//新增（添加真题集）
		pmapper.insert(p);
		
	}
	@Override
	public void update(part p) {//更新真题集信息
		pmapper.update(p);
		
	}
	@Override
	public void delete(int pid) {//删除
		pmapper.delete(pid);
	}
	@Override
	public part findPartById(int pid) {//根据id寻找真题集
		return pmapper.findPartById(pid);
	}
	@Override
	public List<part> queryList() {
		return pmapper.queryList();
	}
/******************************真题detail*************************************/	
	
	@Override
	public PageResult<partdetail> findDPageResult(Object object, int page, int pagesize) {//具体题目
		PageResult<partdetail> result = new PageResult<partdetail>();
		result.setCode(0);
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
        //select * from bank limit 0,10
		parmas.put("start", (page-1)*pagesize);
		parmas.put("pageSize", pagesize);
		//获取总记录数据
		int totalCount=pmapper.findNumByMap(parmas);//记录
		result.setCount(totalCount);
		//获取查询数据
		List<partdetail> list=pmapper.findDPartByMap(parmas);
		
		
		result.setData(list); 
		return result;
	}
	@Override
	public void insertdetail(partdetail pd) {//新增
		pmapper.insertdetail(pd);
		
	}
	@Override
	public void updatedetail(partdetail pd) {//更新
		pmapper.updatedetail(pd);
	}
	@Override
	public void deleteissue(int id) {
		// TODO Auto-generated method stub
		pmapper.deleteById(id);
	}

	
	
	@Override
	public boolean importPartInfo(String fileName, InputStream is) {
		try {
			 List<partdetail> pList = excelUtils.uploadpart(fileName, is);
			 for (int i = 0; i <pList.size(); i++){ 
				 String content = pList.get(i).getContent();
				 partdetail q = findByContent(content);// 查找数据库中看这个题目信息是否存在
				 if (q != null){ updateById(pList.get(i)); //更新数据库中的题目信息 
				 pList.remove(i); // 移除更新后的题目
				 i = i - 1; //因为移除了，所以quesList大小减了一而循环加了一，所以要减回去 
				 } 
			} 
			 return addBatchPart(pList); // 批量添加
		 } catch (Exception e) { 
			 e.printStackTrace();
			 return false; 
	 	} 
	}
	
	/**
     * 根据id修改真题信息
     * @param partdetail 题目信息
     * @return 是否修改成功
     */
	private boolean updateById(partdetail p) {
		return pmapper.updateById(p) > 0;
		
	}
	private boolean addBatchPart(@Param("pList")List<partdetail> pList) {
		return pmapper.addBatchPart(pList) > 0;
	}
	private partdetail findByContent(String content) {//根据题目内容寻找
		return pmapper.findByContent(content);
	}
	
	
	@Override
	public partdetail findByPid(int id) {//根据id寻找
		return pmapper.findById(id);
	}
	

/***************************************前端操作 *********************************************/
	@Override
	public PageResult<part> findPartResult() {//真题表的操作
		PageResult<part> result = new PageResult<part>();
		//int totalCount=pmapper.findCountPart();
		List<part> list=pmapper.findPartResult();
		result.setData(list);
		return result;
		
		//return pmapper.findPartResult();
	}
	@Override
	public PageResult<partdetail> finddetail(int pno) {//根据真题id（即年份）查找题目
		PageResult<partdetail> presult = new PageResult<partdetail>();
		int num = pmapper.count(pno);//查询记录数
		List<partdetail> dlist = pmapper.findByPno(pno);
		presult.setCode(0);
		presult.setCount(num);
		presult.setData(dlist);
		return presult;
	}
	@Override
	public PageResult<partdetail> showexamwish(String userno, String source) {//查找某一用户收藏的题目（收藏夹）
		PageResult<partdetail> presult = new PageResult<partdetail>();
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
		parmas.put("uno", userno);
		parmas.put("source", source);
		int num = pmapper.countwish(parmas);
		List<partdetail> dlist = pmapper.findstar(parmas);
		presult.setCode(0);
		presult.setCount(num);
		presult.setData(dlist);
		return presult;
	}
	@Override
	public PageResult<partdetail> showwrong(String userno) {//错题
		PageResult<partdetail> presult = new PageResult<partdetail>();
		int num = pmapper.countwrong(userno);
		List<partdetail> dlist = pmapper.showwrong(userno);
		presult.setCode(0);
		presult.setCount(num);
		presult.setData(dlist);
		return presult;
	}





	
}
