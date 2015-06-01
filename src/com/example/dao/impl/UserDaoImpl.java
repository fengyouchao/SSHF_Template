package com.example.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.UserDao;
import com.example.model.User;

/**
 * The class <code>UserDaoImpl</code> represents an user DAO.
 * 
 * @author Youchao Feng
 * @date Jun 1, 2015 10:47:04 PM
 * @version 1.0
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void save(User u) {
    Session s = sessionFactory.getCurrentSession();
    s.save(u);
  }

  @Override
  public boolean checkUserExistsWithName(String usernmae) {
    Session s = sessionFactory.getCurrentSession();
    long count =
        (Long) s.createQuery("select count(*) from User u where u.username = :username")
            .setString("username", usernmae).uniqueResult();
    if (count > 0) {
      return true;
    }
    return false;
  }

  @Override
  public List<User> getUsers() {
    Session s = sessionFactory.getCurrentSession();
    Query query = s.createQuery("from User");
    @SuppressWarnings("unchecked")
    List<User> users = query.list();
    return users;
  }

  @Override
  public User loadById(int id) {
    Session s = sessionFactory.getCurrentSession();
    User user = (User) s.load(User.class, id);
    return user;
  }
  

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

}
