package net.javaguides.springboot.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"", "/"})
    public String home(){
        return "index";
    }
    @GetMapping("/contact")
    public String showContactInfo(Model model) {
        model.addAttribute( "contact@example.com");
        model.addAttribute( "+1234567890");
        return "contact";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
    @GetMapping("/profile")
    public String getProfile(Model model) {
        return "profile";
    }
    @GetMapping("/settings")
    public String settings(Model model) {
        return "settings";

}
}
