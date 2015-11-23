package winter.hell.auth.service.impl;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
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
import winter.hell.util.Md5Utils;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            logger.error("queryUserInfoByMobile error", e);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_QUERY_USERINFO_BY_MOBILE);
        }
        if (hellUser != null){
            logger.info("duplicated mobile : {}", mobile);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_DUPLICATED_MOBILE);
        }
    }

    @Override
    public boolean register(RegisterParam registerParam) throws HellAuthServiceException {
        logger.info("register data : {}", registerParam);
        //检查该手机号是否注册过
        queryUserInfoByMobile(registerParam);
        HellUser hellUser = BeanAndDtoTransfer.transOneToAnother(registerParam, HellUser.class, true);
        try{
            setRegisterParam(registerParam, hellUser);
            hellUserMapper.insertSelective(hellUser);
        }catch (Exception e){
            logger.info("insert into user when register error", e);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_REGISTER);
        }
        return true;
    }

    @Override
    public LoginCheckDto loginCheck(LoginCheckParam loginCheckParam) throws HellAuthServiceException {
        logger.info("loginCheck and the data is {}", loginCheckParam);
        LoginCheckDto loginCheckDto = null;
        String mobile = loginCheckParam.getMobile();
        String password = loginCheckParam.getPassword();    //md5
        HellUser hellUser;
        try{
            hellUser = hellUserMapper.queryUserInfoByMobile(mobile);
        }catch (Exception e){
            logger.error("query user by mobile when login check error", e);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_QUERY_USERINFO_BY_MOBILE);
        }
        //库中的salt
        String salt = hellUser.getSalt();
        String afterPassword;
        try {
            //根据前端传入的密码和库中的salt生成的密码md5
            afterPassword = Md5Utils.generate(password+salt);
        } catch (NoSuchAlgorithmException e) {
            logger.error("md generate error", e);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_MD5_ENCRYPTION);
        }
        if(hellUser.getPassword().equals(afterPassword)){
            //验证通过，生成token入库，返回前端

            return loginCheckDto;
        }else{
            //验证失败
            logger.info("login check error, {}", loginCheckParam);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_LOGIN_CHECK);
        }
    }



    public static void setRegisterParam(RegisterParam registerParam, HellUser hellUser) throws NoSuchAlgorithmException {
        String salt = new Random().nextInt(1000)+"";
        String password = Md5Utils.generate(registerParam.getPassword()+salt);
        hellUser.setSalt(salt);
        hellUser.setPassword(password);
        hellUser.setBirthday(new Timestamp(registerParam.getBirthday()));
        hellUser.setRegisterAt(new Timestamp(registerParam.getRegister_at()));
    }

}
