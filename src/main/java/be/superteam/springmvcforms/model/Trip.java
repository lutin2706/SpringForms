package be.superteam.springmvcforms.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Trip {

    private UUID uuid;

    @Size(min = 5, max=100, message = "Name length should be between 5 and 100 characters")
    private String name;

    @Min(value = 2, message = "Duration should be greater than 1")
    private int duration;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @Min(value = 1, message = "A country must be chosen")
    private int country;

    private List<Country> countriesAvailable;

    public Trip() {
    }

    public Trip(UUID uuid, String name, int duration, LocalDate departureDate, int country) {
        this.uuid = uuid;
        this.name = name;
        this.duration = duration;
        this.departureDate = departureDate;
        this.country = country;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public List<Country> getCountriesAvailable() {
        return countriesAvailable;
    }

    public void setCountriesAvailable(List<Country> countriesAvailable) {
        this.countriesAvailable = countriesAvailable;
    }
}
