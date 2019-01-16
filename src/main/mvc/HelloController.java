package main.mvc;

import main.compiler.Compiler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String greeting(Model model,
                           @RequestParam(value = "name", required = false) String name) {
        model.addAttribute("greeting", "안녕하세요. " + name + "님!");
        return "hello";
    }

    @RequestMapping("/compile")
    public String compile(Model model) throws IOException {
//        String code = "public class Test {\n	public static void main(String[] args) {\n		System.out.println(\"Hello, World!\");\n	}\n}";

        Compiler compiler = new Compiler();
        String result = compiler.execte("");
        model.addAttribute("result", result);

        return "compiler";
    }
}

