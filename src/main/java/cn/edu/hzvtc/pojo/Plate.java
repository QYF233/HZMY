package cn.edu.hzvtc.pojo;

import lombok.*;

import java.util.List;

/**
 * @author kiko
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Plate {
    private Integer id;

    private String plaName;

    private String plaUrl;

    private Integer plaSort;

    private Integer plaParentId;

    private String plaPic;

    private Integer plaType;

    private Integer plaDelState;

    private List<Plate> childPlate;
    private List<Plate> children;
    private List<Article> articles;

    private Long sightCount;

    private String text;

    private List<Plate> nodes;
}
