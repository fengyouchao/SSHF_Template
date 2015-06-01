package com.example.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The class <code>FileListAction</code> represents
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
@Controller
@Scope("prototype")
public class FileListAction extends ActionSupport {

  private static final long serialVersionUID = 1L;

  private List<File> files = null;

  @Override
  public String execute() throws Exception {

    String downloadDir = ServletActionContext.getServletContext().getRealPath("/upload");
    System.out.println("downloadFolderPath:" + downloadDir);
    files = new ArrayList<>();
    File file = new File(downloadDir);
    File[] arrayfiles = file.listFiles();
    for (int i = 0; i < arrayfiles.length; i++) {
      if (!arrayfiles[i].isDirectory()) {
        files.add(arrayfiles[i]);
      }
    }
    return SUCCESS;
  }

  public List<File> getFiles() {
    return files;
  }

  public void setFiles(List<File> files) {
    this.files = files;
  }

}
