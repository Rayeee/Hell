package winter.hell.webapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import winter.hell.framework.ResponseEntity;


/**
 * Created by ZGY on 15/11/18.
 */
@Controller("/pingController")
@RequestMapping("/hell-webapi")
public class PingController {

    private Logger logger = LoggerFactory.getLogger(PingController.class);

    @ResponseBody
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> ping(){
        return ResponseEntity.success("success");
    }

}
