package ra.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoryCotroller {
    @RequestMapping("/category")
    public String index(){
        return "admin/category/index";
    }
}
