package cn.edu.hzvtc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id;

    private String artTitle;

    private String artAuthor;

    private String artPic;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date artTime;

    private Integer artPlateId;

    private Integer artFileId;

    private Integer artOperatorId;

    private Integer artTop;

    private Integer artDelState;

    private String artContent;

    private Integer artSight;
}