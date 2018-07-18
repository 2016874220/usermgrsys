package com.lingnan.usersys.common.util;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.MailException;
/**
 * 邮箱格式验证
 * @author Administrator
 *
 */
public class CheckMailUtils
{
	/**
	 * 检测邮箱格式是否正确
	 * @param mail
	 * @return 返回布尔值isExist。当isExist=true，邮箱格式正确；反之错误
	 */
	public static boolean isNameAdressFormat(String mail){ 
		boolean isExist = false; 
		Pattern p = Pattern.compile
				("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"); 
		Matcher m = p.matcher(mail);
		boolean b = m.matches();
		if(b) {
			isExist=true; 
			}
		else {
			System.out.println("无效邮件地址");
			}
		return isExist; 
	}
}
