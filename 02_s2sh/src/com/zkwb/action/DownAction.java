package com.zkwb.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 实现读取本地excel模板，添加数据后输出
 * @author Administrator
 *
 */
public class DownAction extends ActionSupport{
	private static final long serialVersionUID = -6142156106399579541L;
	private String fileName;  
    private String mimeType;
    private InputStream excelStream;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
    
	public String download(){
		try {
			fileName = "测试excel.xls";
			String path = ServletActionContext.getServletContext().getRealPath("/");
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(path +"/test.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row = sheet.createRow(3);
			HSSFCell c1 = row.createCell(0);
			c1.setCellValue("语文");
			HSSFCell c2 = row.createCell(1);
			c2.setCellValue("数学");
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			wb.write(out);
			
			byte[] ba = out.toByteArray();
			excelStream = new ByteArrayInputStream(ba);
			out.flush();
			out.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
