package winter.hell.webapi.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import winter.hell.webapi.auth.dto.RegisterLoginDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ZGY on 15/11/18.
 */
@Controller("userLoginController")
@RequestMapping("/")
public class UserLoginController {

    private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ModelAndView login(@RequestParam String username,@RequestParam String password, HttpSession session){
        logger.info("user login and the username is {}", username);
        session.setAttribute(username, 1);
        System.out.println(session.getAttribute(username));
        ModelAndView mav = new ModelAndView("/pages/index");
        return mav;
    }


    @RequestMapping(value="/pictures",method=RequestMethod.GET)
    public String toHome(HttpServletRequest request, HttpServletResponse response) {
        return "pages/pictures/pictures";
    }

}
