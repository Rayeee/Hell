package winter.hell.webapi.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import winter.hell.auth.dto.LoginCheckParam;
import winter.hell.auth.dto.RegisterParam;
import winter.hell.auth.exception.HellAuthServiceException;
import winter.hell.auth.service.IHellAuthLoginService;
import winter.hell.util.ServletUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ZGY on 15/11/18.
 */
@Controller("userLoginController")
@RequestMapping("/hell-webapi")
public class UserLoginController {

    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @Resource
    private IHellAuthLoginService hellAuthLoginService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView register(@RequestBody RegisterParam registerParam, HttpSession session) throws HellAuthServiceException {
        logger.info("user register and the mobile is {}", registerParam.getMobile());
        try{
            registerParam.validate(registerParam);
            hellAuthLoginService.register(registerParam);
        }catch (HellAuthServiceException e){
            throw e;
        }
        ModelAndView mav = new ModelAndView("/pages/login/login");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView login(@RequestBody LoginCheckParam loginCheckParam, HttpServletRequest request) throws HellAuthServiceException{
        logger.info("user login and the mobile is {}", loginCheckParam.getMobile());
        try{
            hellAuthLoginService.loginCheck(loginCheckParam, request);
        }catch (HellAuthServiceException e){
            throw e;
        }
        ModelAndView mav = new ModelAndView("/pages/index");
        return mav;
    }

    @RequestMapping(value="/pictures",method=RequestMethod.GET)
    public String toHome(HttpServletRequest request, HttpServletResponse response) {
        return "pages/pictures/pictures";
    }

}
