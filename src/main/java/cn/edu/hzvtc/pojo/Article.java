package cn.edu.hzvtc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Article {
    private Integer id;

    private String artTitle;

    private String artAuthor;

    private String artPic;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date artTime;

    private Integer artPlateId;

    private Integer artFileId;

    private Integer artOperatorId;

    private Integer artTop;

    private Integer artDelState;

    private String artContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle == null ? null : artTitle.trim();
    }

    public String getArtAuthor() {
        return artAuthor;
    }

    public void setArtAuthor(String artAuthor) {
        this.artAuthor = artAuthor == null ? null : artAuthor.trim();
    }

    public String getArtPic() {
        return artPic;
    }

    public void setArtPic(String artPic) {
        this.artPic = artPic == null ? null : artPic.trim();
    }

    public Date getArtTime() {
        return artTime;
    }

    public void setArtTime(Date artTime) {
        this.artTime = artTime;
    }

    public Integer getArtPlateId() {
        return artPlateId;
    }

    public void setArtPlateId(Integer artPlateId) {
        this.artPlateId = artPlateId;
    }

    public Integer getArtFileId() {
        return artFileId;
    }

    public void setArtFileId(Integer artFileId) {
        this.artFileId = artFileId;
    }

    public Integer getArtOperatorId() {
        return artOperatorId;
    }

    public void setArtOperatorId(Integer artOperatorId) {
        this.artOperatorId = artOperatorId;
    }

    public Integer getArtTop() {
        return artTop;
    }

    public void setArtTop(Integer artTop) {
        this.artTop = artTop;
    }

    public Integer getArtDelState() {
        return artDelState;
    }

    public void setArtDelState(Integer artDelState) {
        this.artDelState = artDelState;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent == null ? null : artContent.trim();
    }
}