package com.example.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;


/**
 * The class <code>FileUploadAction</code> represents an action that support to upload files.
 * 
 * @author Youchao Feng
 * @version 1.0
 *
 */
@Controller
@Scope("prototype")
public class FileUploadAction extends ActionSupport {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  private int bufferSize;
  // 文件标题
  private String title;
  // 上传文件域对象
  private File[] upload;
  // 上传文件名
  private String[] uploadFileName;
  // 上传文件类型
  private String[] uploadContentType;
  // 保存文件的目录路径(通过依赖注入)
  private String savePath;


  // 自己封装的一个把源文件对象复制成目标文件对象
  private static void copy(File src, File dst, int bufferSize) {
    InputStream in = null;
    OutputStream out = null;
    try {
      in = new BufferedInputStream(new FileInputStream(src), bufferSize);
      out = new BufferedOutputStream(new FileOutputStream(dst), bufferSize);
      byte[] buffer = new byte[bufferSize];
      int len = 0;
      while ((len = in.read(buffer)) > 0) {
        out.write(buffer, 0, len);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (null != in) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (null != out) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  @Override
  public String execute() throws Exception {

    String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath()) + "/";
    System.out.println(upload.length);
    for (int i = 0; i < upload.length; i++) {
      System.out.println("文件名" + getUploadFileName()[i]);
      System.out.println("文件扩展名" + getUploadContentType()[i]);
      String filePath = dstPath + getUploadFileName()[i];
      File file = new File(filePath);
      copy(this.upload[i], file, bufferSize);
    }
    return SUCCESS;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public File[] getUpload() {
    return upload;
  }

  public void setUpload(File[] upload) {
    this.upload = upload;
  }

  public String[] getUploadFileName() {
    return uploadFileName;
  }

  public void setUploadFileName(String[] uploadFileName) {
    this.uploadFileName = uploadFileName;
  }

  public String[] getUploadContentType() {
    return uploadContentType;
  }

  public void setUploadContentType(String[] uploadContentType) {
    this.uploadContentType = uploadContentType;
  }

  public String getSavePath() {
    return savePath;
  }

  public void setSavePath(String savePath) {
    this.savePath = savePath;
  }

  public int getBufferSize() {
    return bufferSize;
  }

  public void setBufferSize(int bufferSize) {
    this.bufferSize = bufferSize;
  }

}
