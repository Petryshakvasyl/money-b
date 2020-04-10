package ua.lviv.lgs.money.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.lgs.money.controller.validator.UserValidator;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.service.UserService;
import ua.lviv.lgs.money.service.event.RegisterUserEvent;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    private final UserValidator userValidator;

    private final UserService userService;

    private final ApplicationEventPublisher eventPublisher;

    public UserController(UserValidator userValidator, UserService userService,
                          ApplicationEventPublisher eventPublisher) {
        this.userValidator = userValidator;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(HttpServletRequest request, @ModelAttribute("userForm") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.registerNewUser(user);
        eventPublisher.publishEvent(new RegisterUserEvent(this, user, request.getContextPath()));
        return "redirect:/login";
    }
}
