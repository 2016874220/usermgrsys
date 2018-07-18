package com.lingnan.usersys.usermgr.business.service;

import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * �û�service�ӿ�
 * @author Administrator
 *
 */
public interface UserService
{
	/**
	 * �û���¼
	 * @param name �û���
	 * @param passwd ����
	 * @return �û���Ϣ
	 */
	public UserVO login(String name, String passwd);
	
	/**
	 * ע��/����û�
	 * @param user
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
