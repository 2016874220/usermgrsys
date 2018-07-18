package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.List;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVO;
/**
 * 
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	/**
	 * �û�service��ʵ��
	 */
	private static UserService userService = new UserServiceImpl();
	
	/**
	 * ���췽��
	 */
	private UserServiceImpl(){
		
	}
	
	/**
	 * ȡ���û�serviceʵ��
	 * @return ʵ������
	 */
	public static UserService getInstance(){
		return userService;
	}
	
	/**
	 * �û���¼
	 * @param name �û���
	 * @param passwd ����
	 * @return �û���Ϣ
	 */
	public UserVO login(String name, String passwd){
		//�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn = null;
		UserVO user = null;
		//�������ݿ⹤�����getConnection����,ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
		conn = DBUtils.getConnection();
		//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
		UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
		//����dao�е�login���������е�¼�����������ֵ����¼�������
		user = userMgrDao.login(name, passwd);
		try{
			
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("�û���¼����",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//�����û���¼���
		return user;
	}
	
	/**
	 * ���/ע���û�
	 * @param user �û���Ϣ
	 * @return ��flag=true�����/ע���û��ɹ�����flag=false�����/ע���û�ʧ��
	 */
	public boolean addUser(UserVO user)
	{
		//�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn = null;
		//�������������ڱ������ݿ������
		boolean flag = false;
		try{
			//�������ݿ⹤�����getConnection����,ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn = DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�addUser�������������ݿ��������������ֵ������������
			flag = userMgrDao.addUser(user);
			//�������ݿ⹤�����commit�������ύ����
			DBUtils.commit(conn);
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���������г����쳣���������ݿ⹤�����rollback�������ع�����
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("��ӻ�ע���û�����",e);
		}finally{
			//�������ݿ⹤�����closeConnection�������ر�����
			DBUtils.closeConnection(conn);
		}
		//�������ݿ������
		return flag;
	}

	/**
	 * ����id�����û�
	 * @param id �û����
	 * @return �û���Ϣ 
	 */
	public UserVO findUserById(int id)
	{
		//�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn = null;
		UserVO user = null;
		//�������ݿ⹤�����getConnection����,ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
		conn = DBUtils.getConnection();
		//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
		UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
		//����dao�е�findUserById���������е�¼�����������ֵ����¼�������
		user = userMgrDao.findUserById(id);
		try{
			
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("����id��ѯ�û�����",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//�����û���¼���
		return user;
	}

	@Override public List<UserVO> findUserByName(String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override public List<UserVO> findAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override public boolean updateUser(UserVO user)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override public boolean daleteUser(int id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override public List<UserVO> findUsers(int pageNo, int pageSize)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override public int getRecordCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
