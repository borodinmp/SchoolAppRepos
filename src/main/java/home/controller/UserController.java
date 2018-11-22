package home.controller;

import home.domain.Role;
import home.domain.User;
import home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userid") User user
    ) {
        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(
            Model model,
            @AuthenticationPrincipal User user) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("fullname", user.getFullName());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam("password") String password,
            @RequestParam("password2") String passwordConfirm,
            @RequestParam("fullName") String fullName,
            Model model
    ) {

        model.addAttribute("username", user.getUsername());
        model.addAttribute("fullname", user.getFullName());

        if (fullName.isEmpty()) {
            model.addAttribute("fullNameError", "Пожалуйста, введите фамилию, имя и отчество");
            return "profile";
        }
        if (password.isEmpty() || !password.equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Пароли не совпадают либо не введены");
            return "profile";
        }
        userService.updateProfile(user, password, fullName);
        return "redirect:/user/profile";
    }
}
