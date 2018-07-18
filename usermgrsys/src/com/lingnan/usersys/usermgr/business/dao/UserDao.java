package com.lingnan.usersys.usermgr.business.dao;

import java.util.List;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 用户dao接口
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao{
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param passwd 密码
	 * @param user 用户信息
	 * @return 用户信息
	 */
	public UserVO login(String name, String passwd);
	
	/**
	 * 注册/添加用户
	 * @param user 用户信息
	 * @return 成功返回true；失败返回false
	 */
	public boolean addUser(UserVO user);
	
	/**
	 * 根据id查找用户
	 * @param id 用户编号
	 * @return 用户信息
	 */
	public UserVO findUserById(int id);
	
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 用户信息
	 */
	public List<UserVO> findUserByName(String name);
	
	/**
	 * 查询所有用户
	 * @return 用户信息
	 */
	public List<UserVO> findAll();
	
	/**
	 * 更新用户
	 * @param user 用户信息
	 * @return 成功返回true；失败返回false
	 */
	public boolean updateUser(UserVO user);
	
	/**
	 * 删除用户
	 * @param id 用户编号
	 * @return 成功返回true；失败返回false
	 */
	public boolean daleteUser(int id);
	
	/**
	 * 获取指定页的用户信息
	 * @param pageNo
	 * @param pageSize
	 * @return 用户信息
	 */
	public List<UserVO> findUsers(int pageNo,int pageSize);
	
	/**
	 * 获取记录数量
	 * @return 记录数量
	 */
	public int getRecordCount();
}
