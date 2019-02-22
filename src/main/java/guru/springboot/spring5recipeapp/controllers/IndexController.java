package guru.springboot.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Darshana Welikala on 2019-02-17.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index";
    }

}
