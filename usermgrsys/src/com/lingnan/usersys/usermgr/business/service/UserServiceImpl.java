package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.List;
import java.util.Vector;

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
	 * ɾ���û�
	 * @param id �û����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean deleteUser(int id){
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
			//����dao�е�deleteUser�������������ݿ�ɾ�������������ֵ��ɾ���������
			flag = userMgrDao.deleteUser(id);
			//System.out.println("**********************"+flag);
			//�������ݿ⹤�����commit�������ύ����
			DBUtils.commit(conn);
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���������г����쳣���������ݿ⹤�����rollback�������ع�����
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("ɾ���û�����",e);
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

	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findUserByName(String name)
	{
		//�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn = null;
		Vector<UserVO> v = null;
		//�������ݿ⹤�����getConnection����,ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
		conn = DBUtils.getConnection();
		//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
		UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
		//����dao�е�findUserById���������е�¼�����������ֵ����¼�������
		v = userMgrDao.findUserByName(name);
		try{
			
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("�����û�����ѯ�û�����",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//�����û���¼���
		return v;
	}

	/**
	 * ��ѯ�����û�
	 * @return �û���Ϣ
	 */
	public Vector<UserVO> findAll()
	{
		//�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn = null;
		Vector<UserVO> v = null;
		//�������ݿ⹤�����getConnection����,ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
		conn = DBUtils.getConnection();
		//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
		UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
		//����dao�е�findAll���������е�¼�����������ֵ����¼�������
		v = userMgrDao.findAll();
		try{
			
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("��ѯ�û�����",e);
		}finally{
			DBUtils.closeConnection(conn);
		}
		//�����û���¼���
		return v;
	}
	
	/**
	 * ����id�����û�
	 * @param id �û����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean updateUser(UserVO user,int userid)
	{
		//�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn = null;
		//�������������ڱ������ݿ��޸Ľ��
		boolean flag = false;
		try{
			//�������ݿ⹤�����getConnection����,ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn = DBUtils.getConnection();
			//����dao�������getDao������ȡ��ָ�����͵�dao�ӿڵ�ʵ���࣬����ֵ��dao�ӿڱ���
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//�������ݿ⹤�����beginTransaction��������������
			DBUtils.beginTransaction(conn);
			//����dao�е�updateUser�������������ݿ��޸Ĳ����������ֵ���޸Ľ������
			flag = userMgrDao.updateUser(user,userid);
			//�������ݿ⹤�����commit�������ύ����
			DBUtils.commit(conn);
		}catch(DaoException e){
			//���Զ����쳣�׳�
			throw e;
		}catch(Exception e){
			//���������г����쳣���������ݿ⹤�����rollback�������ع�����
			DBUtils.rollback(conn);
			//���쳣��װ���Զ����쳣���׳�
			throw new ServiceException("�޸��û�����",e);
		}finally{
			//�������ݿ⹤�����closeConnection�������ر�����
			DBUtils.closeConnection(conn);
		}
		//�������ݿ��޸Ľ��
		return flag;
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
