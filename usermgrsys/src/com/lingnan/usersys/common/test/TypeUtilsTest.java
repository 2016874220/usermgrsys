package com.lingnan.usersys.common.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

import com.lingnan.usersys.common.util.TypeUtils;
/**
 * 测试工具类TypeUtils
 * @author Administrator
 *
 */
public class TypeUtilsTest
{
	@Test 
	public void test() throws ParseException
	{
		System.out.println("请输入日期：");
		Scanner reader = new Scanner(System.in);
		String birth = reader.next();
		Date date = TypeUtils.strToDate(birth);
		String str = TypeUtils.dateToStr(date);
		System.out.println("您输入的日期为：");
		System.out.println(str);
	}
}
