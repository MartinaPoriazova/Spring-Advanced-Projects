package bg.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

}