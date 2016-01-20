package com.zkwb.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	/**
	 * 讲时间字符串解析成日期对象
	 * @param dateString 输入的时间字符串
	 * @param format 格式化类型
	 * @return
	 */
	public static Date stringToDate(String dateString,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
