package be.superteam.springmvcforms.service.impl;

import be.superteam.springmvcforms.model.Country;
import be.superteam.springmvcforms.model.SelectItem;
import be.superteam.springmvcforms.repository.CountryRepo;
import be.superteam.springmvcforms.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    CountryRepo countryRepo;

    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> getList() {
        return countryRepo.findAll();
    }
}
