package winter.hell.auth.service;


import winter.hell.auth.dto.LoginCheckDto;
import winter.hell.auth.dto.LoginCheckParam;
import winter.hell.auth.dto.RegisterParam;
import winter.hell.auth.exception.HellAuthServiceException;

/**
 * Created by ZGY on 15/11/21.
 */
public interface IHellAuthLoginService {

    /**
     * 根据手机号码查询用户，验证该手机号码是否重复注册
     * @param registerParam
     * @throws HellAuthServiceException
     */
    void queryUserInfoByMobile(RegisterParam registerParam) throws  HellAuthServiceException;

    /**
     * 用户注册
     * @param registerParam
     * @return
     * @throws HellAuthServiceException
     */
    boolean register(RegisterParam registerParam) throws HellAuthServiceException;

    /**
     * 用户登录验证，如果成功，返回token
     * @param loginCheckParam
     * @return
     * @throws HellAuthServiceException
     */
    LoginCheckDto loginCheck(LoginCheckParam loginCheckParam) throws HellAuthServiceException;

}
