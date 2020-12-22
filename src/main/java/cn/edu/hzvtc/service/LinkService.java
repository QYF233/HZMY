package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Link;

import java.util.List;

public interface LinkService {
    /**
     * 获取友链
     *
     * @return
     */
    List<Link> getLinks();

    Link getLink(Integer id);

    int updateLink(Link link);

    int updateSort(Integer id, Integer newSort);

    int delLink(Integer id);

    int addLink(Link link);
}
