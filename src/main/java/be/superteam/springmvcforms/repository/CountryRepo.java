package be.superteam.springmvcforms.repository;

import be.superteam.springmvcforms.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
