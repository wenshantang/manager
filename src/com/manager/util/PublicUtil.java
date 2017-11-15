package com.manager.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.puff.jdbc.core.Record;

public class PublicUtil {
	public static ByteArrayInputStream createExcel(String sheetName,String[] cellKeys,String [] cellNames,List<Record> dataList) throws IOException{
		return PublicUtil.createExcel(sheetName, cellKeys, cellNames, dataList, 5000);
	}
	
	public static ByteArrayInputStream createExcel(String sheetName,String[] cellKeys,String[] cellNames,List<Record> dataList,int width) throws IOException{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		//头部定义
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		for(int i=0;i<cellNames.length;i++){
			sheet.setColumnWidth(i, width);
			cell = row.createCell(i);
			cell.setCellValue(cellNames[i]);
		}
		//数据填充
		Record record = null;
		for(int i=0;i<dataList.size();i++){
			record=(Record)dataList.get(i);
			row = sheet.createRow(i+1);
			for (int j = 0; j < cellKeys.length; j++) {
				cell = row.createCell(j);
				cell.setCellValue(record.get(cellKeys[j])==null?"":record.get(cellKeys[j])+"");
			}
		}
		wb.write(byteArrayOutputStream);
		return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	}
}
