package cn.edu.hzvtc.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Integer id;

    private String linkName;

    private String linkUrl;

    private Integer linkSort;

    private Integer linkDelState;

}