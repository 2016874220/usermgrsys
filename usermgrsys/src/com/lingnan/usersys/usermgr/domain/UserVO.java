package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

/**
 * 用户信息类
 * @author Administrator
 *
 */
public class UserVO
{
	private Integer id; //主键
	private String name; //用户名
	private String passwd; //密码
	private String mail; //邮箱
	private Date birth; //出生日期
	private Integer superuser; //标志
	/**
	 * 取得用户编号
	 * @return 编号
	 */
	public Integer getId()
	{
		return id;
	}
	/**
	 * 设置用户编号为指定参数的值
	 * @param id 编号
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}
	/**
	 * 取得用户名
	 * @return 用户名
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 设置用户名为指定参数的值
	 * @param name 用户名
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * 取得用户密码
	 * @return 密码
	 */
	public String getPasswd()
	{
		return passwd;
	}
	/**
	 * 设置密码为指定参数的值
	 * @param passwd 密码
	 */
	public void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}
	/**
	 * 取得用户邮箱
	 * @return 邮箱
	 */
	public String getMail()
	{
		return mail;
	}
	/**
	 * 设置邮箱为指定参数的值
	 * @param mail 邮箱
	 */
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	/**
	 * 取得用户出生日期
	 * @return 出生日期
	 */
	public Date getBirth()
	{
		return birth;
	}
	/**
	 * 设置出生日期为指定参数的值
	 * @param date 出生日期
	 */
	public void setBirth(Date date)
	{
		this.birth = date;
	}
	/**
	 * 取得用户身份的标志
	 * @return 标志
	 */
	public Integer getSuperuser()
	{
		return superuser;
	}
	/**
	 * 设置标志为指定参数的值
	 * @param superuser 标志
	 */
	public void setSuperuser(Integer superuser)
	{
		this.superuser = superuser;
	}
}
