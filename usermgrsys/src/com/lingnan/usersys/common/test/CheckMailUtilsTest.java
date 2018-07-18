package com.lingnan.usersys.common.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

import com.lingnan.usersys.common.util.CheckMailUtils;
/**
 * 测试工具类CheckMailUtils
 * @author Administrator
 *
 */
public class CheckMailUtilsTest
{
	@Test 
	public void test()
	{
		System.out.println("请输入邮箱：");
		Scanner reader = new Scanner(System.in);
		String mail = reader.next();
		CheckMailUtils.isNameAdressFormat(mail);
	}
}
