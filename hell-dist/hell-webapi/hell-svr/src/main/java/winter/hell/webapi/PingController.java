package winter.hell.webapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import winter.hell.dto.TestUserDto;
import winter.hell.exception.HellServiceException;
import winter.hell.framework.ResponseEntity;
import winter.hell.service.TestService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZGY on 15/11/18.
 */
@Controller("/pingController")
@RequestMapping("/hell-webapi")
public class PingController {

    private Logger logger = LoggerFactory.getLogger(PingController.class);

    @Resource
    private TestService testService;

    @ResponseBody
    @RequestMapping(value = "/test/query/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<TestUserDto> testQuery(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Integer id){
        logger.info("testQuery and id is {}", id);
        TestUserDto testUserDto = null;
        try {
            testUserDto = testService.queryOneTest(id);
        } catch (HellServiceException e) {
            return ResponseEntity.fail(e.getErrorCode(), e.getLocalizedMessage(),null);
        }
        return ResponseEntity.success(testUserDto);
    }

}
