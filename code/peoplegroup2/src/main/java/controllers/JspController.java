package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jerieshasmith on 4/2/17.
 */
@Controller
public class JspController {

    @RequestMapping(value="/jspTest")
    public String jspTest() {
        return "test/test";
    }
}
