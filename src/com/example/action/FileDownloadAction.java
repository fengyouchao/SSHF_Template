package com.example.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * The class <code>FileDownloadAction</code> represents
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
@Controller
@Scope("prototype")
public class FileDownloadAction extends ActionSupport {

  private static final long serialVersionUID = 1L;
  private String fileName; // 初始的通过param指定的文件名属性
  private String inputPath; // 指定要被下载的文件路径


  public InputStream getInputStream() throws Exception {
    InputStream in = ServletActionContext.getServletContext().getResourceAsStream(inputPath);
    return in;
  }


  @Override
  public String execute() throws Exception {
    // 文件下载目录路径
    String downloadDir = ServletActionContext.getServletContext().getRealPath("/upload");
    // 文件下载路径
    String downloadFile = ServletActionContext.getServletContext().getRealPath(inputPath);
    java.io.File file = new java.io.File(downloadFile);
    downloadFile = file.getCanonicalPath();// 真实文件路径,去掉里面的..等信息
    // 发现企图下载不在 /download 下的文件, 就显示空内容
    if (!downloadFile.startsWith(downloadDir)) {
      return null;
    }
    return SUCCESS;
  }

  public void setInputPath(String value) {
    inputPath = value;
    fileName = inputPath.substring(inputPath.lastIndexOf("/") + 1);
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /** 提供转换编码后的供下载用的文件名 */
  public String getDownloadFileName() {
    String downFileName = fileName;
    try {
      downFileName = new String(downFileName.getBytes(), "ISO8859-1");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return downFileName;
  }

}
