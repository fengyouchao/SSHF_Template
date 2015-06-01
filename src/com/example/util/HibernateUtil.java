package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * The class <code>HibernateUtil</code> is an utility for Hibernate.
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
public class HibernateUtil {

  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      Configuration cfg = new Configuration();
      ServiceRegistry serviceRegistry =
          new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
      return cfg.configure().buildSessionFactory(serviceRegistry);
    } catch (Throwable ex) {
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
