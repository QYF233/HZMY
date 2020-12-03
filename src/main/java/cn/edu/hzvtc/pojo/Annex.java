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
public class Annex {
    private Integer id;

    private String fileName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date fileTime;

    private Integer fileDown;

    private Integer fileType;

    private Integer fileDelState;

    public Annex(String fileName, Date fileTime, Integer fileDown, Integer fileType) {
        this.fileName = fileName;
        this.fileTime = fileTime;
        this.fileDown = fileDown;
        this.fileType = fileType;
    }
}