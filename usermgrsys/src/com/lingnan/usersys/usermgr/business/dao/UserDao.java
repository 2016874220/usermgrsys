package com.lingnan.usersys.usermgr.business.dao;

import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * �û�dao�ӿ�
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao{
	/**
	 * �û���¼
	 * @param name �û���
	 * @param passwd ����
	 * @param user �û���Ϣ
	 * @return �û���Ϣ
	 */
	public UserVO login(String name, String passwd);
	
	/**
	 * ע��/����û�
	 * @param user �û���Ϣ
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean addUser(UserVO user);
	
	/**
	 * ɾ���û�
	 * @param id �û����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean deleteUser(int id);
	
	/**
	 * ����id�����û�
	 * @param id �û����
	 * @return �û���Ϣ
	 */
	public UserVO findUserById(int id);
	
	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findUserByName(String name);
	
	/**
	 * ��ѯ�����û�
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findAll();
	
	/**
	 * ����id�����û�
	 * @param id �û����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean updateUser(UserVO user,int userid);
	
	/**
	 * ��ȡָ��ҳ���û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return �û���Ϣ
	 */
	public List<UserVO> findUsers(int pageNo,int pageSize);
	
	/**
	 * ��ȡ��¼����
	 * @return ��¼����
	 */
	public int getRecordCount();
}
