package cn.edu.hzvtc.pojo;

import java.util.Date;

public class File {
    private Integer id;

    private String fileName;

    private Date fileTime;

    private Integer fileDown;

    private Integer fileType;

    private Integer fileDelState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Date getFileTime() {
        return fileTime;
    }

    public void setFileTime(Date fileTime) {
        this.fileTime = fileTime;
    }

    public Integer getFileDown() {
        return fileDown;
    }

    public void setFileDown(Integer fileDown) {
        this.fileDown = fileDown;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getFileDelState() {
        return fileDelState;
    }

    public void setFileDelState(Integer fileDelState) {
        this.fileDelState = fileDelState;
    }
}