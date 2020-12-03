package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.AnnexMapper;
import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.service.AnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnexServiceImpl implements AnnexService {
    @Autowired
    private AnnexMapper annexMapper;

    @Override
    public int addAnnex(Annex annex) {
        return annexMapper.insert(annex);
    }

    @Override
    public Annex getAnnex(Integer id) {
        return annexMapper.selectByPrimaryKey(id);
    }
}
