package cn.edu.tongji.software_igem2021.igemwebbackend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MAP {

    @RequestMapping(value = "/haha", method = RequestMethod.GET)
    String haha() {
        return "haha";
    }
}
