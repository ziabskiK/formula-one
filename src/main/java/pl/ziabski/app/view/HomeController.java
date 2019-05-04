package pl.ziabski.app.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap modelMap){
        modelMap.put("hello", "Witaj świecie");
        return "home";
    }
}
