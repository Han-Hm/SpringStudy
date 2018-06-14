package main.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String greeting(Model model,
                           @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("greeting", "안녕하세요. " + name + "님!");
        return "hello";
    }
}

