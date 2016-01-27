package com.zkwb.test;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zkwb.common.ExcelUtils;

public class ActionTest extends ActionSupport{
	public static void main(String[] args) {
		String path = ServletActionContext.getServletContext().getRealPath("/");
		String result = ExcelUtils.Excel2String(path + "/test2.xls");
		System.out.println(result);
	}
}
