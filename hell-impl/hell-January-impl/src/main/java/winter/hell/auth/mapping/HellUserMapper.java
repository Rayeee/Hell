package winter.hell.auth.mapping;

import org.apache.ibatis.annotations.Param;
import winter.hell.auth.model.HellUser;

public interface HellUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HellUser record);

    int insertSelective(HellUser record);

    HellUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HellUser record);

    int updateByPrimaryKey(HellUser record);

    HellUser queryUserInfoByMobile(@Param("mobile")String mobile);
}