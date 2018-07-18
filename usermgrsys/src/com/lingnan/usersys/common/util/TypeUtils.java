package com.lingnan.usersys.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.generator.qdox.parser.ParseException;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.DateException;

/**
 * 类型转换工具类
 * @author Administrator
 *
 */
public class TypeUtils{
	/**
	 * 字符串转换为日期
	 * @param str 指定的字符串
	 * @return 转换后的日期
	 * @throws java.text.ParseException 
	 */
	public static Date strToDate(String str) throws java.text.ParseException{
		Date date = null;
		//设置要格式化的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			//调用parse方法，将字符串解析成指定格式的日期类型
			date = sdf.parse(str);
		}catch(ParseException e){
			//将异常封装成自定义异常
			throw new DateException("字符串转换为日期出错",e);
			//e.printStackTrace();
		}
	//返回转换后的
	return date;
	}
	
	/**
	 * 日期转换为字符串
	 * @param date 指定日期
	 * @return 转换后的字符串
	 */
	public static String dateToStr(Date date){
		String str = null;
		try{
			//设置要格式化的日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//调用format方法，将日期格式化成字符串
			str = sdf.format(date);
		}catch(Exception e){
			//将异常封装成自定义异常
			throw new DateException("日期转换为字符串失败",e);
			//e.printStackTrace();
		}
		//返回转换后的值
		return str;
	}
}
