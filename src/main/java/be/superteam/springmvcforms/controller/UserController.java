package be.superteam.springmvcforms.controller;

import be.superteam.springmvcforms.model.UserForm;
import be.superteam.springmvcforms.service.CountryService;
import be.superteam.springmvcforms.service.impl.TripServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private TripServiceImpl tripService;
    private CountryService countryService;

    public UserController(TripServiceImpl tripService, CountryService countryService) {
        this.tripService = tripService;
        this.countryService = countryService;
    }

    @GetMapping("/user")
    public String user(Model model) {
        UserForm userForm = new UserForm();
        userForm.setCountriesAvailable(countryService.getList());
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
            userForm.setCountriesAvailable(countryService.getList());
            return "user";
        }
        model.addAttribute("userForm", userForm);
        return "result";
    }
}
