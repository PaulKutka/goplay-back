package Controller;

import Entity.User;
import Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(User user)
    {
        if(loginService.isUserAuthenticated(user))
        {
            return user;
        }
        return "Something wrong";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(User user)
    {
        return loginService.registerUser(user);
    }
}
