package be.superteam.springmvcforms.controller;

import be.superteam.springmvcforms.model.SelectItem;
import be.superteam.springmvcforms.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    List<SelectItem> availableCountries = Arrays.asList(
            new SelectItem(1, "Portugal"),
            new SelectItem(2, "Espagne"),
            new SelectItem(3, "Italie"),
            new SelectItem(4,"Ailleurs où il fait froid")
    );

    @GetMapping("/user")
    public String user(Model model) {
        UserForm userForm = new UserForm();
        userForm.setCountriesAvailable(availableCountries);
        userForm.setCountrySelected(2);
        model.addAttribute("userForm", userForm);
        return "user";
    }

    @PostMapping("/user")
    public String user(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        if (!userForm.getPassword().equals(userForm.getPasswordCheck())) {
            bindingResult.addError(new FieldError("userForm", "passwordCheck", "Passwords must be the same"));
        }
        if (bindingResult.hasErrors()) {
            userForm.setCountriesAvailable(availableCountries);
            return "user";
        }
        model.addAttribute("userForm", userForm);
        return "result";
    }
}
