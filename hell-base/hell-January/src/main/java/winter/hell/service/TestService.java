package winter.hell.service;

import winter.hell.dto.TestUserDto;
import winter.hell.exception.HellServiceException;

/**
 * Created by ZGY on 15/11/18.
 */
public interface TestService {

    TestUserDto queryOneTest(Integer id) throws HellServiceException;

}
