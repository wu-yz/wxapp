package com.tedu.wxadmin.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.tedu.wxadmin.model.partdetail;
import com.tedu.wxadmin.model.question;



@Component
public class ImportExcelUtils {///题目批量
	// 将表格中的数据添加到List集合中
    public List<question> upload(String fileName, InputStream is) throws Exception{
        Workbook workbook = getWorkbook(fileName,is);//读取excel文件
        List<question> quesList = new ArrayList<>();
        int number = workbook.getNumberOfSheets(); //获取sheet值
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i); //获取表格页码
            if (sheet != null){
                int rowNum = sheet.getLastRowNum(); // 获取该页表共有多少行
                for (int j = 1; j <= rowNum; j++) {  // 一般来说第一行是标题,所以第二行开始读取
                    Row row = sheet.getRow(j); // 获取表格行
                    question q = new question();//新建对象，将单元格的值赋给对象的属性
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); // 将该单元格获取出来的值设为String类型
                    q.setQuesType(row.getCell(0).getStringCellValue()); // 获取表格单元格并给question设置值
                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    q.setChapter(row.getCell(1).getStringCellValue());
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    q.setContent(row.getCell(2).getStringCellValue());
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    q.setAns(row.getCell(3).getStringCellValue());
                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    q.setAoption(row.getCell(4).getStringCellValue());
                    row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                    q.setBoption(row.getCell(5).getStringCellValue());
                    row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                    q.setCoption(row.getCell(6).getStringCellValue());
                    row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                    q.setDoption(row.getCell(7).getStringCellValue());
                    row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                    q.setAnalysis(row.getCell(8).getStringCellValue());
                    row.getCell(9).setCellType(Cell.CELL_TYPE_NUMERIC);
                    int id = (int)row.getCell(9).getNumericCellValue();
                    //row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                    q.setBankid(id);
                    System.out.println(q);
                    quesList.add(q);//对象加入到list当中
                }
            }
        }
        return quesList;

    }

    // 判断传入的文件是哪种类型的excel文件
    public Workbook getWorkbook(String fileName,InputStream is) throws Exception{
        Workbook workbook = null;
        String name = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(name);
        if (".xls".equals(name)){
            workbook = new HSSFWorkbook(is);
        }else if (".xlsx".equals(name)){
            workbook = new XSSFWorkbook(is);
        }else {
            throw new Exception(" 请上传.xls/.xlsx格式文件！");
        }
        return workbook;
    }
    
 // 将表格中的数据添加到List集合中,真题
    public List<partdetail> uploadpart(String fileName, InputStream is) throws Exception{
        Workbook workbook = getWorkbook(fileName,is);
        List<partdetail> pList = new ArrayList<>();
        int number = workbook.getNumberOfSheets(); // 获取sheet值
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i); // 获取表格页码
            if (sheet != null){
                int rowNum = sheet.getLastRowNum(); // 获取该页表共有多少行
                for (int j = 1; j <= rowNum; j++) {  // 一般来说第一行是标题,所以第二行开始读取
                    Row row = sheet.getRow(j); // 获取表格行
                    partdetail p = new partdetail();
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING); // 将该单元格获取出来的值设为String类型
                    p.setType(row.getCell(0).getStringCellValue()); // 获取表格单元格并给User设置值
                    row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                    p.setContent(row.getCell(1).getStringCellValue());
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    p.setAns(row.getCell(2).getStringCellValue());
                    row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                    p.setAoption(row.getCell(3).getStringCellValue());
                    row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                    p.setBoption(row.getCell(4).getStringCellValue());
                    row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                    p.setCoption(row.getCell(5).getStringCellValue());
                    row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                    p.setDoption(row.getCell(6).getStringCellValue());
                    row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                    p.setAnalysis(row.getCell(7).getStringCellValue());
                    row.getCell(8).setCellType(Cell.CELL_TYPE_NUMERIC);
                    int id = (int)row.getCell(8).getNumericCellValue();
                    //row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                    p.setPartNo(id);
                    System.out.println(p);
                    pList.add(p);
                }
            }
        }
        return pList;

    }
   
}
