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

    int updateByPrimaryKey(Annex record);

    int addAnnexDown(Integer id);
}