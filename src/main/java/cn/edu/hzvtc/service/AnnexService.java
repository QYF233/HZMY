package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Annex;

public interface AnnexService {
    public int addAnnex(Annex annex);

    public Annex getAnnex(Integer id);

    public int addAnnexDown(Integer id);
}
