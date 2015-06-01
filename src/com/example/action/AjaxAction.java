package com.example.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The class <code>AjaxAction</code> represents
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
@Controller
@Scope("prototype")
public class AjaxAction extends ActionSupport {

  private static final long serialVersionUID = 1L;

  @Override
  public String execute() throws Exception {
    return SUCCESS;
  }

}
