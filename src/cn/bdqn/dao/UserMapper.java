package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.pojo.Address;
import cn.bdqn.pojo.Department;
import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.User;

public interface UserMapper {
	public int count();
	
	public void add(User user);
	
	public void update(User user);
	
	public void del(User user);
	
	public List<User> getUserList();
	
	//根据roleId获取用户列表
	public List<User> getUserListByRoleId(Role role);
	
	public List<User> getUserListByDepId(Department dep);
	
	public User getAddressListByUserId(User user);
	
	//动态SQL
	public List<User> searchUserList(User user);
}
