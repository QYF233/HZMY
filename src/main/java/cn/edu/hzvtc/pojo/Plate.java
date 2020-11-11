package cn.edu.hzvtc.pojo;

public class Plate {
    private Integer id;

    private String plaName;

    private String plaUrl;

    private Integer plaSort;

    private Integer plaParentId;

    private String plaPic;

    private Integer plaType;

    private Integer plaDelState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName == null ? null : plaName.trim();
    }

    public String getPlaUrl() {
        return plaUrl;
    }

    public void setPlaUrl(String plaUrl) {
        this.plaUrl = plaUrl == null ? null : plaUrl.trim();
    }

    public Integer getPlaSort() {
        return plaSort;
    }

    public void setPlaSort(Integer plaSort) {
        this.plaSort = plaSort;
    }

    public Integer getPlaParentId() {
        return plaParentId;
    }

    public void setPlaParentId(Integer plaParentId) {
        this.plaParentId = plaParentId;
    }

    public String getPlaPic() {
        return plaPic;
    }

    public void setPlaPic(String plaPic) {
        this.plaPic = plaPic == null ? null : plaPic.trim();
    }

    public Integer getPlaType() {
        return plaType;
    }

    public void setPlaType(Integer plaType) {
        this.plaType = plaType;
    }

    public Integer getPlaDelState() {
        return plaDelState;
    }

    public void setPlaDelState(Integer plaDelState) {
        this.plaDelState = plaDelState;
    }
}