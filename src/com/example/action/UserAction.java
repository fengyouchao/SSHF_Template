package com.example.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.example.dto.UserRigisterInfo;
import com.example.model.User;
import com.example.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * The class <code>UserAction</code> represents
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<Object> {

  private static final long serialVersionUID = 1L;

  private UserRigisterInfo info = new UserRigisterInfo();

  private int id;

  @Autowired
  private UserService userService;

  private List<User> users;

  private User user;

  @Override
  public String execute() throws Exception {
    System.out.println("In Action:" + info.getUsername());
    User u = new User();
    u.setUsername(info.getUsername());
    u.setPassword(info.getPassword());
    if (userService.add(u)) {
      return SUCCESS;
    }
    return ERROR;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UserService getUserManager() {
    return userService;
  }

  public void setUserManager(UserService userManager) {
    this.userService = userManager;
  }

  public UserRigisterInfo getInfo() {
    return info;
  }

  public void setInfo(UserRigisterInfo info) {
    this.info = info;
  }

  @Override
  public Object getModel() {
    return info;
  }

  public String list() {
    this.users = this.userService.getUsers();
    return "list";
  }

  public String load() {
    user = userService.loadById(id);
    return "load";
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
