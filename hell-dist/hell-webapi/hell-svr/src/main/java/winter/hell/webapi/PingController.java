package winter.hell.webapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import winter.hell.framework.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by ZGY on 15/11/18.
 */
@Controller("pingController")
@RequestMapping("/hell-webapi")
public class PingController {

    private Logger logger = LoggerFactory.getLogger(PingController.class);

    @ResponseBody
    @RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> ping(){
        return ResponseEntity.success("success");
    }


    public static void main(String[] args) {
        List<Long> list1 = new ArrayList<>();
        for (long i = 0; i < 200; i++) {
            list1.add(i);
        }

        List<Long> list2 = new ArrayList<>();
        for (long i = 100; i < 150; i++) {
            list2.add(i);
        }

        List<Long> collect = list2.stream().filter(i -> {
            return list1.contains(i);
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
