package winter.hell.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import winter.hell.dto.TestUserDto;
import winter.hell.exception.HellServiceException;
import winter.hell.mapping.TestUserMapper;
import winter.hell.model.TestUser;
import winter.hell.service.TestService;
import winter.hell.util.BeanAndDtoTransfer;

import javax.annotation.Resource;

/**
 * Created by ZGY on 15/11/18.
 */
@Service
public class TestServiceImpl implements TestService{

    @Resource
    private TestUserMapper testUserMapper;

    @Override
    public TestUserDto queryOneTest(Integer id) throws HellServiceException {
        TestUser testUser = null;
        try{
            testUser = testUserMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        TestUserDto testUserDto = BeanAndDtoTransfer.transOneToAnother(testUser, TestUserDto.class, true);
        return testUserDto;
    }
}
