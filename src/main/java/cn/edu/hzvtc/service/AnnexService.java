package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Annex;

public interface AnnexService {
    /**
     * 添加附件
     * @param annex
     * @return
     */
    public int addAnnex(Annex annex);

    /**
     * 获取附件
     * @param id
     * @return
     */
    public Annex getAnnex(Integer id);

    /**
     * 添加下载次数
     * @param id
     * @return
     */
    public int addAnnexDown(Integer id);
}
