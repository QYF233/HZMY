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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date fileTime;

    private Integer fileDown;

    private String fileType;

    private Integer fileDelState;

    private String fileRealName;

    public Annex(String fileName,String fileRealName, Date fileTime, Integer fileDown, String fileType) {
        this.fileName = fileName;
        this.fileRealName = fileRealName;
        this.fileTime = fileTime;
        this.fileDown = fileDown;
        this.fileType = fileType;
    }
}
