package com.tedu.wxadmin.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tedu.wxadmin.mapper.QuesMapper;
import com.tedu.wxadmin.model.PageResult;
import com.tedu.wxadmin.model.question;
//import com.tedu.wxadmin.util.ImportExcelUtils;
import com.tedu.wxadmin.service.IQuesService;
import com.tedu.wxadmin.utils.ImportExcelUtils;

@Service
public class IQuesServiceImpl implements IQuesService{
	@Autowired
	QuesMapper qmapper;
	@Resource
	ImportExcelUtils excelUtils;

	@Override
	public PageResult<question> findPageResult(question condition, int page, int limit) {
		PageResult<question> qresult = new PageResult<question>();
		qresult.setCode(0);
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
		parmas.put("condition", condition);
        //select * from user limit 0,10
		parmas.put("start", (page-1)*limit);
		parmas.put("pageSize", limit);//设置页面大小，一页显示多少条
		//获取总记录数据
		int totalCount=qmapper.findCountByMap(parmas);
		qresult.setCount(totalCount);
		//获取查询数据
		List<question> list=qmapper.findQuesByMap(parmas);		
		qresult.setData(list); 
		return qresult;
	}
	@Override
	public question findByQid(int qno) {//根据id寻找题目
		// TODO Auto-generated method stub
		return qmapper.findByQid(qno);
	}
	
	
	/**
     * 批量添加题目信息
     * @param quesList 题目信息
     * @return 题目信息是否添加成功
     */
	
	 public boolean addBatchQues(@Param("quesList") List<question> quesList) { 
		 return qmapper.addBatchQues(quesList) > 0; 
		 
	 }
	 
	 /*
	  * 根据题目内容查找题目信息
	  * 
	  * 
	  * */
	 public question findQuesByContent(String content) {
		 return qmapper.findQuesByContent(content);
	 }
    

    /**
     * 根据用户账号修改题目信息
     * @param question 题目信息
     * @return 是否修改成功
     */
	 public boolean updateQuesById(question q) { 
	 	return qmapper.updateQuesById(q) > 0; 
	 }
	 

    /**
     * 批量导入题目信息（敲重点！！！！！）
     * @param fileName 导入的表名
     * @param is 导入表的输入流
     * @return 是否导入成功
     */
	
	 public boolean importQuesInfo(String fileName, InputStream is){ 
		 try {
			 List<question> quesList = excelUtils.upload(fileName, is);
			 for (int i = 0; i <quesList.size(); i++){ 
				 String content = quesList.get(i).getContent();
				 question q = findQuesByContent(content);// 查找数据库中看这个题目信息是否存在
				 if (q != null){ updateQuesById(quesList.get(i)); //更新数据库中的题目信息 
				 quesList.remove(i); // 移除更新后的题目
				 i = i - 1; //因为移除了，所以quesList大小减了一而循环加了一，所以要减回去 
				 } 
			} 
			 return addBatchQues(quesList); // 批量添加
		 } catch (Exception e) { 
			 e.printStackTrace();
			 return false; 
	 	} 
	 }
	@Override
	public void deleteByQid(int id) {//删除
		qmapper.deleteByQid(id);
		
	}
	@Override
	public void save(question q) {//新增题目信息
		qmapper.insert(q);
		
	}
	@Override
	public void update(question q) {//更新题目信息
		qmapper.update(q);
	}
	
	/****************小程序方法实现**********************/
	
	@Override
	public PageResult findchapter(int bno) {//根据id查找所有章节
		PageResult qresult = new PageResult();
		qresult.setCode(0);
		List list = qmapper.findchapterlist(bno);
		qresult.setData(list);
		return qresult;
	}
	@Override
	public PageResult<question> quesByChapId(int bankid, String chapter) {//根据id 章节查题目信息（实现接口）
		PageResult<question> result = new PageResult<question>();
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
		parmas.put("bid", bankid);
		parmas.put("chapter", chapter);
		result.setCode(0);
		int num = qmapper.count(parmas);
		List<question> qlist = qmapper.quesByChapId(parmas);
		result.setCount(num);
		result.setData(qlist);
		return result;
	}
	@Override
	public PageResult<question> showwrong(String userno) {//查询错题
		PageResult<question> result = new PageResult<question>();
		int num = qmapper.countwrong(userno);
		List<question> qlist = qmapper.showwrong(userno);
		result.setCode(0);
		result.setCount(num);
		result.setData(qlist);
		//map.put("wrong",map );
		return result;
	}
	@Override
	public PageResult<question> showtestwish(String userno, String source) {//收藏夹
		PageResult<question> result = new PageResult<question>();
		//查询参数    设置为空
		Map<String,Object> parmas=new HashMap<String,Object>();
		parmas.put("uno", userno);
		parmas.put("source", source);
		result.setCode(0);
		int num = qmapper.countwish(parmas);
		List<question> qlist = qmapper.findtestwish(parmas);
		result.setCount(num);
		result.setData(qlist);
		return result;
	}

	 

	

}
