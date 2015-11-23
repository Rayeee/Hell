package winter.hell.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import winter.hell.auth.dto.LoginCheckDto;
import winter.hell.auth.dto.LoginCheckParam;
import winter.hell.auth.dto.RegisterParam;
import winter.hell.auth.exception.HellAuthExceptionCode;
import winter.hell.auth.exception.HellAuthServiceException;
import winter.hell.auth.mapping.HellSessionMapper;
import winter.hell.auth.mapping.HellUserMapper;
import winter.hell.auth.model.HellSession;
import winter.hell.auth.model.HellUser;
import winter.hell.auth.service.IHellAuthLoginService;
import winter.hell.util.BeanAndDtoTransfer;
import winter.hell.util.Md5Utils;
import winter.hell.util.ServletUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;

/**
 * Created by ZGY on 15/11/21.
 */
@Service
public class HellAuthLoginServiceImpl implements IHellAuthLoginService{

    private static Logger logger = LoggerFactory.getLogger(HellAuthLoginServiceImpl.class);

    @Resource
    private HellUserMapper hellUserMapper;

    @Resource
    private HellSessionMapper hellSessionMapper;

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
    public LoginCheckDto loginCheck(LoginCheckParam loginCheckParam, HttpServletRequest request) throws HellAuthServiceException {
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
        if (hellUser == null){
            logger.info("unknown mobile of {}", loginCheckParam.getMobile());
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_UNKNOWN_MOBILE);
        }
        //库中的salt
        String afterPassword;
        try {
            //根据前端传入的密码和库中的salt生成的密码md5
            afterPassword = Md5Utils.generate(password + hellUser.getSalt());
        } catch (NoSuchAlgorithmException e) {
            logger.error("md generate error", e);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_MD5_ENCRYPTION);
        }
        if(hellUser.getPassword().equals(afterPassword)){
            //验证通过，生成token入库，返回前端
            Integer userId = hellUser.getId();
            generateToken(userId, mobile, request);
            return loginCheckDto;
        }else{
            //验证失败
            logger.info("login check error, {}", loginCheckParam);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_LOGIN_CHECK);
        }
    }

    @Override
    public String generateToken(Integer id, String mobile, HttpServletRequest request) throws HellAuthServiceException {
        logger.info("generateToken, user_id:{},mobile:{}", id, mobile);
        HellSession hellSession = new HellSession();
        generateSessionInfo(hellSession, request);
        hellSession.setUserId(id);
        hellSession.setMobile(mobile);
        String token = UUID.randomUUID().toString();
        hellSession.setToken(token);
        hellSession.setExpireTime(new Timestamp(new Date().getTime()+1000*60*60));
        try{
            hellSessionMapper.insertSelective(hellSession);
        }catch (Exception e){
            logger.error("insert into user_session failed", e);
            throw new HellAuthServiceException(HellAuthExceptionCode.ERROR_SYSTEM);
        }
        return token;
    }

    public static void generateSessionInfo(HellSession hellSession, HttpServletRequest request) throws HellAuthServiceException{
        try{
            //获取用户IP
            String ip = ServletUtils.getIpAddr(request);
            String mac = ServletUtils.getMACAddress(ip);
            hellSession.setUserMac(mac);
        }catch (Exception e){
            logger.info("get mac error");
        }
        try{
            //获取用户浏览器，操作系统
            String agent = request.getHeader("User-Agent");
            StringTokenizer st = new StringTokenizer(agent,";");
            String browser = st.nextToken();
            String os = st.nextToken();
            hellSession.setUserOs(os);
        }catch (Exception e){
            logger.info("get os error");
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

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(Md5Utils.generate("111111"));
    }
}
