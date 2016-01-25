package com.zkwb.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelUtils {
	public static String Excel2String(String path) {
		FileInputStream fis = null;
		StringBuilder sb = new StringBuilder("");
		try {
			fis = new FileInputStream(path);
			
			Workbook wb = Workbook.getWorkbook(fis);
			Sheet[] sheets = wb.getSheets();//得到所有的工作表
			for (int i = 0; i < sheets.length; i++) {
				Sheet sheet = sheets[i];
				for (int j = 0; j < sheet.getRows(); j++) {//遍历当前工作表的所有行
					Cell[] cells = sheet.getRow(j);
					for (int k = 0; k < cells.length; k++) {//遍历当前行的所有列
						sb.append(cells[k].getContents());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
