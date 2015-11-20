package winter.hell.webapi.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import winter.hell.auth.dto.LoginParam;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView login(@RequestBody LoginParam loginParam){
        logger.info("user login and the username is {}", loginParam.getUser_name());
        ModelAndView mav = new ModelAndView("/pages/index");
        return mav;
    }

    @RequestMapping(value="/pictures",method=RequestMethod.GET)
    public String toHome(HttpServletRequest request, HttpServletResponse response) {
        return "pages/pictures/pictures";
    }

}
