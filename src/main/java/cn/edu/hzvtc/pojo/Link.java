package cn.edu.hzvtc.pojo;

public class Link {
    private Integer id;

    private String linkName;

    private String linkUrl;

    private Integer linkSort;

    private Integer linkDelState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Integer getLinkSort() {
        return linkSort;
    }

    public void setLinkSort(Integer linkSort) {
        this.linkSort = linkSort;
    }

    public Integer getLinkDelState() {
        return linkDelState;
    }

    public void setLinkDelState(Integer linkDelState) {
        this.linkDelState = linkDelState;
    }
}