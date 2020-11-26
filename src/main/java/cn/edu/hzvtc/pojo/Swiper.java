package cn.edu.hzvtc.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Swiper {
    private Integer id;

    private String swiName;

    private String swiDescribe;

    private String swiPic;

    private Integer swiArtId;

    private Integer swiSort;

    private Integer swiDelState;

}