package com.example.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;


@Service
public class UserManagerImpl implements UserService {

  private UserDao userDao;

  @Override
  public boolean exist(User u) throws Exception {
    return userDao.checkUserExistsWithName(u.getUsername());
  }

  @Override
  public boolean add(User u) throws Exception {
    if (exist(u)) {
      return false;
    }
    userDao.save(u);
    return true;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  @Resource
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public List<User> getUsers() {
    return userDao.getUsers();
  }

  @Override
  public User loadById(int id) {
    return userDao.loadById(id);
  }

}
