package com.lingnan.usersys.common.test;

import java.sql.Connection;

import org.junit.Test;

import com.lingnan.usersys.common.util.DBUtils;
/**
 * 测试工具类DBUtils
 * @author Administrator
 *
 */
public class DBUtilsTest
{
	@Test 
	public void test()
	{
		Connection connection = DBUtils.getConnection();
		System.out.println(connection);
	}
}
