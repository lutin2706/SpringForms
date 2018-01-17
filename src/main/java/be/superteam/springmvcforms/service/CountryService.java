package be.superteam.springmvcforms.service;

import be.superteam.springmvcforms.model.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    private List<Country> availableCountries = Arrays.asList(
            new Country(1, "Portugal"),
            new Country(2, "Espagne"),
            new Country(3, "Italie"),
            new Country(4,"Indonésie"),
            new Country(1000,"Ailleurs où il fait froid")
    );

    public List<Country> getAvailableCountries() {
        return availableCountries;
    }
}
