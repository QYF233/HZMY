package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Annex;

import java.util.List;

/**
 * @author kiko
 */
public interface AnnexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Annex record);

    Annex selectByPrimaryKey(Integer id);


    List<Annex> selectAll();

    /**
     * 更新附件信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Annex record);

    /**
     * 增加下载数
     *
     * @param id
     * @return
     */
    int addAnnexDown(Integer id);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deleteAnnexById(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteAnnexByList(List<Integer> ids);
}