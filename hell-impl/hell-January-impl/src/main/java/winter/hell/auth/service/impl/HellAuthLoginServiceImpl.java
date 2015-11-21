package winter.hell.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import winter.hell.auth.dto.LoginCheckDto;
import winter.hell.auth.dto.LoginCheckParam;
import winter.hell.auth.dto.RegisterParam;
import winter.hell.auth.dto.UserInfoDto;
import winter.hell.auth.exception.HellAuthExceptionCode;
import winter.hell.auth.exception.HellAuthServiceException;
import winter.hell.auth.mapping.HellUserMapper;
import winter.hell.auth.model.HellUser;
import winter.hell.auth.service.IHellAuthLoginService;
import winter.hell.util.BeanAndDtoTransfer;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Random;

/**
 * Created by ZGY on 15/11/21.
 */
@Service
public class HellAuthLoginServiceImpl implements IHellAuthLoginService{

    private Logger logger = LoggerFactory.getLogger(HellAuthLoginServiceImpl.class);

    @Resource
    private HellUserMapper hellUserMapper;

    @Override
    public void queryUserInfoByMobile(RegisterParam registerParam) throws HellAuthServiceException {

        logger.info("queryUserInfoByMobile and the mobile is {}", registerParam.getMobile());
        String mobile = registerParam.getMobile();
        HellUser hellUser = null;
        try{
           hellUser = hellUserMapper.queryUserInfoByMobile(mobile);
        }catch (Exception e){
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_QUERY_USERINFO_BY_MOBILE);
        }
        if (hellUser != null){
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_DUPLICATED_MOBILE);
        }
    }

    //TODO: 在注册的时候，如何处理密码存储
    @Override
    public boolean register(RegisterParam registerParam) throws HellAuthServiceException {
        logger.info("register data : {}", registerParam);
        queryUserInfoByMobile(registerParam);
        HellUser hellUser = BeanAndDtoTransfer.transOneToAnother(registerParam, HellUser.class, true);
        hellUser.setBirthday(new Timestamp(registerParam.getBirthday()));
        hellUser.setRegisterAt(new Timestamp(registerParam.getRegister_at()));
        //TODO: 将参数分离
        String salt = "hell";
        StringBuilder sb = new StringBuilder();
        sb.append(registerParam.getMobile())
                .append(registerParam.getPassword())
                .append(salt);
        String password = sb.toString();
        try{
            hellUserMapper.insertSelective(hellUser);
        }catch (Exception e){
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_REGISTER);
        }
        return true;
    }

    @Override
    public LoginCheckDto loginCheck(LoginCheckParam loginCheckParam) throws HellAuthServiceException {
        logger.info("loginCheck and the data is {}", loginCheckParam);
        String mobile = loginCheckParam.getUser_name();
        String password = loginCheckParam.getPassword();//md5

        //根据account登录
        return null;
    }
}
