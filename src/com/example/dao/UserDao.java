package com.example.dao;

import java.util.List;

import com.example.model.User;

/**
 * The class <code>UserDao</code> represents
 * 
 * @author Youchao Feng
 * @date Jun 1, 2015 10:46:02 PM
 * @version 1.0
 *
 */
public interface UserDao {

  public void save(User u);

  public boolean checkUserExistsWithName(String usernmae);

  public List<User> getUsers();

  public User loadById(int id);

}
