package com.feng.registration.action;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.action.UserAction;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
//		UserAction ua = new UserAction();
//		ua.setUsername("g");
//		ua.setPassword("2");
//		String ret= ua.execute();
//		System.out.println(ret);
	}
	
	@Test
	public void testList() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserAction ua = (UserAction)ctx.getBean("userAction");
		ua.list();
		Assert.assertTrue(ua.getUsers().size() > 0);
	}
	
	@Test
	public void testUser() throws Exception{
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserAction ua = (UserAction)ctx.getBean("userAction");
		String user = ua.load();
		System.out.println(user);
	}
	
	@Test
	public void test(){
		String a = "women/123/we.jsp";
		System.out.println(a.lastIndexOf("/"));
		System.out.println(a.substring(a.lastIndexOf("/")+1));
	}

}