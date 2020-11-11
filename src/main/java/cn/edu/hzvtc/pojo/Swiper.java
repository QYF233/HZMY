package cn.edu.hzvtc.pojo;

public class Swiper {
    private Integer id;

    private String swiName;

    private String swiDescribe;

    private String swiPic;

    private Integer swiArtId;

    private Integer swiSort;

    private Integer swiDelState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSwiName() {
        return swiName;
    }

    public void setSwiName(String swiName) {
        this.swiName = swiName == null ? null : swiName.trim();
    }

    public String getSwiDescribe() {
        return swiDescribe;
    }

    public void setSwiDescribe(String swiDescribe) {
        this.swiDescribe = swiDescribe == null ? null : swiDescribe.trim();
    }

    public String getSwiPic() {
        return swiPic;
    }

    public void setSwiPic(String swiPic) {
        this.swiPic = swiPic == null ? null : swiPic.trim();
    }

    public Integer getSwiArtId() {
        return swiArtId;
    }

    public void setSwiArtId(Integer swiArtId) {
        this.swiArtId = swiArtId;
    }

    public Integer getSwiSort() {
        return swiSort;
    }

    public void setSwiSort(Integer swiSort) {
        this.swiSort = swiSort;
    }

    public Integer getSwiDelState() {
        return swiDelState;
    }

    public void setSwiDelState(Integer swiDelState) {
        this.swiDelState = swiDelState;
    }
}