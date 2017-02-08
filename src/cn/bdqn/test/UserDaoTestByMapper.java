package cn.bdqn.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.Address;
import cn.bdqn.pojo.Department;
import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.User;
import cn.bdqn.util.MyBatisUtil;

public class UserDaoTestByMapper {
	private static Logger logger = Logger.getLogger(UserDaoTestByMapper.class);
	
	
	@Test
	public void getUserListByRoleTest(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		Role role = new Role();
		role.setId(2);
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userList = sqlSession.getMapper(UserMapper.class).getUserListByRoleId(role);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		
		logger.debug("getUserListByRoleTest count=======>"+userList.size());
		for (User user : userList) {
			logger.debug("========"+user.getUserName()+","+user.getRole().getRoleName()+","+user.getRoleId());
			
		}
	}
	
	
	
	
	@Test
	public void getUserListByDepTest(){
		SqlSession sqlSession = null;
		User user = new User();
		user.setId(1);
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			user = sqlSession.getMapper(UserMapper.class).getAddressListByUserId(user);
			sqlSession.commit();
		} catch (Exception e) {;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		
		logger.debug("getUserListByDepTest userId==="+user.getId());
		logger.debug("------"+user.getAddressList().size());
		logger.debug("UserName======"+user.getUserName());
		for (Address a : user.getAddressList()) {
			logger.debug("Address=========="+a.getAddressContent()+","+a.getPostCode());
		}
	}
	
	
	//动态SQL查询测试
	@Test
	public void getUserList(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		
		User user = new User();
		/*user.setRoleId(1);*/
		user.setUserCode("t");
		/*user.setUserName("测");*/
		
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userList = sqlSession.getMapper(UserMapper.class).searchUserList(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		
		for (User user1 : userList) {
			logger.debug("user==="+user1.getUserName()+","+user1.getRoleName()+","+user1.getUserCode());
		}
	}
	
	//动态SQL修改测试
	@Test
	public void updateTest(){
		SqlSession sqlSession = null;
		User user = new User();
		user.setId(2);
		user.setUserCode("");
		user.setUserName("施敬超");
		user.setUserPassword("777777");
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			sqlSession.getMapper(UserMapper.class).update(user);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
	}
	
	//动态SQL循环测试
	@Test
	public void getUserByDepId_foreach_arrayTest(){
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		String[] depIds = {"1","2"};
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userList = sqlSession.getMapper(UserMapper.class).getUserByDepId_foreach_array(depIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		for (User u : userList) {
			logger.debug("userList=="+u.getUserName()+","+u.getUserCode());
		}
	}
}
