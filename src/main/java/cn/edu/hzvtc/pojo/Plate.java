package cn.edu.hzvtc.pojo;

public class Plate {
    private Integer id;

    private String secName;

    private String secUrl;

    private Integer secSort;

    private Integer secParentId;

    private String secPic;

    private Integer secType;

    private Integer secDelState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName == null ? null : secName.trim();
    }

    public String getSecUrl() {
        return secUrl;
    }

    public void setSecUrl(String secUrl) {
        this.secUrl = secUrl == null ? null : secUrl.trim();
    }

    public Integer getSecSort() {
        return secSort;
    }

    public void setSecSort(Integer secSort) {
        this.secSort = secSort;
    }

    public Integer getSecParentId() {
        return secParentId;
    }

    public void setSecParentId(Integer secParentId) {
        this.secParentId = secParentId;
    }

    public String getSecPic() {
        return secPic;
    }

    public void setSecPic(String secPic) {
        this.secPic = secPic == null ? null : secPic.trim();
    }

    public Integer getSecType() {
        return secType;
    }

    public void setSecType(Integer secType) {
        this.secType = secType;
    }

    public Integer getSecDelState() {
        return secDelState;
    }

    public void setSecDelState(Integer secDelState) {
        this.secDelState = secDelState;
    }
}