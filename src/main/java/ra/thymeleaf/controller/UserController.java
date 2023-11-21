package ra.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.thymeleaf.modle.entity.User;
import ra.thymeleaf.service.UserService;

import javax.servlet.http.HttpSession;


@Controller
    @RequestMapping(value = "/user")

    public class UserController {

    @Autowired
 private    UserService userService;


        @RequestMapping("")
        public String index() {

            return "/user/index";
        }

        @GetMapping("/login")
        public String login(Model model){
            User user = new User();
            model.addAttribute("user",user);
            return "/user/login";
        }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") User user, HttpSession httpSession, RedirectAttributes redirectAttributes){
        if(userService.login(user))
        {
            httpSession.setAttribute("email",user.getEmail());
            return "redirect:/user";
        }
        redirectAttributes.addFlashAttribute("err","Sai tt dang nhap");
        return  "redirect:/user/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("email");
        return "redirect:/user";
    };
    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "/user/register";
    };


    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        try {
            userService.save(user);
            return "redirect:/user/login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("err", e.getMessage());
            return "redirect:/user/register";
        }
    }
};


