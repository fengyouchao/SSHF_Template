package com.feng.regisration.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import com.example.model.User;
import com.example.service.UserService;
import com.example.service.impl.UserManagerImpl;
import com.example.util.HibernateUtil;

public class UserManagerTest {
	

	@Test
	public void testExist() {
		User u = new User();
		u.setUsername("admin");
		UserService um = new UserManagerImpl();
		boolean bl = false;
		try {
			bl = um.exist(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, bl);
	}

	@Test
	public void testAdd() throws Exception {
		User u = new User();
		u.setUsername("wang");
		u.setPassword("123");
		UserService um = new UserManagerImpl();
		boolean exists = um.exist(u);
		if(!exists){
			um.add(u);
			u.setUsername("wang");
			Assert.assertEquals(true, um.exist(u));
		}
		else{
			Assert.fail("not added");
		}
	}
	
	@After
	public void close(){
		HibernateUtil.getSessionFactory().close();
	}

}
