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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date artTime;

    private Integer artPlateId;

    private String artSec;

    private String artFileId;

    private String artFileName;

    private Integer artOperatorId;

    private Integer artTop;

    private Integer artDelState;

    private String artContent;

    private Integer artSight;

    private Integer artType;

    private String artOrigin;

    private String artStatus;
}
