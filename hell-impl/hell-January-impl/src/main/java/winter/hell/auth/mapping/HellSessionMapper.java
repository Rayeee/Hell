package winter.hell.auth.mapping;

import winter.hell.auth.model.HellSession;

public interface HellSessionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HellSession record);

    int insertSelective(HellSession record);

    HellSession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HellSession record);

    int updateByPrimaryKey(HellSession record);
}