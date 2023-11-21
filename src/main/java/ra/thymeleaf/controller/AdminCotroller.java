package ra.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")

public class AdminCotroller {
    @RequestMapping("")
    public String index(){
        return "/admin/index";
    }
}
