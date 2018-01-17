package be.superteam.springmvcforms.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.*;

public class UserForm {

    @NotNull
    @Size(min = 3, max = 25, message = "Username length must be between 3 and 25")
    private String username;

    @NotNull
    private String password;

    private String passwordCheck;

    @Min(value = 5, message = "Your experience must be minimum 5 (else, just go to Altran)")
    @Max(100)
    private int experience;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private List<Country> countriesAvailable;

    private int countrySelected;

    @AssertTrue(message = "You must accept conditions to continue")
    private boolean termsAccepted;

    public UserForm() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Country> getCountriesAvailable() {
        return countriesAvailable;
    }

    public void setCountriesAvailable(List<Country> countriesAvailable) {
        this.countriesAvailable = countriesAvailable;
    }

    public int getCountrySelected() {
        return countrySelected;
    }

    public void setCountrySelected(int countrySelected) {
        this.countrySelected = countrySelected;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
