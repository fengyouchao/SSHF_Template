package com.example.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.example.model.User;
import com.example.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * The class <code>GetUserListJSONAction</code> represents
 * 
 * @author Youchao Feng
 * @date Jun 1, 2015 10:44:35 PM
 * @version 1.0
 *
 */
@Controller
@Scope("prototype")
public class GetUserListJSONAction extends ActionSupport {

  private static final long serialVersionUID = 1L;

  private List<User> users;
  
  @Autowired
  private UserService userManager;

  @Override
  public String execute() throws Exception {
    users = userManager.getUsers();
    return SUCCESS;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public UserService getUserManager() {
    return userManager;
  }

  public void setUserManager(UserService userManager) {
    this.userManager = userManager;
  }

}
