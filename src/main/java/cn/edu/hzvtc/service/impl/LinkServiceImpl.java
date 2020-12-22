package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.LinkMapper;
import cn.edu.hzvtc.pojo.Link;
import cn.edu.hzvtc.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    public LinkMapper linkMapper;

    @Override
    public List<Link> getLinks() {
        return linkMapper.selectAll();
    }

    @Override
    public Link getLink(Integer id) {
        return linkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateLink(Link link) {
        return linkMapper.updateByPrimaryKey(link);
    }

    @Override
    public int updateSort(Integer id, Integer newSort) {
        return linkMapper.updateSort(id, newSort);
    }

    @Override
    public int delLink(Integer id) {
        return linkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addLink(Link link) {
        return linkMapper.insert(link);
    }

}
