package winter.hell.webapi;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;
import winter.hell.auth.dto.UserInfoDto;

/**
 * Created by ZGY on 16/1/14.
 */
@Service
public class TestFactoryBean implements FactoryBean<UserInfoDto> {

    @Override
    public UserInfoDto getObject() throws Exception {
        UserInfoDto userInfoDto = new UserInfoDto();
        return userInfoDto;
    }

    public static UserInfoDto getUserInfoDto() {
        UserInfoDto userInfoDto = new UserInfoDto();
        return userInfoDto;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
