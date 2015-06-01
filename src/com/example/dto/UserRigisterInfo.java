package com.example.dto;

/**
 * The class <code>UserRigisterInfo</code> represents an user register information.
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
public class UserRigisterInfo {

  private String username;
  private String password;
  private String password2;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword2() {
    return password2;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }

  public boolean isAvailable() {
    if (username != null && password != null && password2 != null && username.equals("")
        && password.equals("") && password2.equals("") && password.equals(password2)) {
      return true;
    }
    return false;
  }
}
