package crm.controller;

import crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import crm.model.User;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/getUser/{userId}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable(value = "userId") int userId) {
        User user = userService.getUserByUserId(userId);
        return new ModelAndView("userPage", "user", user);
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerCustomer(@ModelAttribute(value = "user") User user,
                                         BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("userPage");
            return modelAndView;
        }
        userService.addUser(user);
        modelAndView.setViewName("success");
        modelAndView.addObject("registrationSuccess", "Registered Successfully. Login using username and password");
        return modelAndView;
    }
}

