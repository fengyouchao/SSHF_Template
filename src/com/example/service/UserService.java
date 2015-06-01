package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {

  public boolean exist(User u) throws Exception;

  public boolean add(User u) throws Exception;

  public List<User> getUsers();

  public User loadById(int id);

}
