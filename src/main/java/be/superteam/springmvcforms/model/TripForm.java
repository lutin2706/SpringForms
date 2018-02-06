package be.superteam.springmvcforms.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class TripForm {

    private Long id;

    @NotNull
    @Size(min = 5, max=100, message = "Name length should be between 5 and 100 characters")
    private String name;

    @Min(value = 2, message = "Duration should be greater than 1")
    private int duration;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @NotNull
    private long countryId;

    private String countryName;

    @NotNull
    private String image;

    List<SelectItem> availableCountries;

    public TripForm() {
    }

    public TripForm(long id, String name, int duration, LocalDate departureDate, long countryId, String countryName, String image) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.departureDate = departureDate;
        this.countryId = countryId;
        this.countryName = countryName;
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setAvailableCountries(List<SelectItem> availableCountries) {
        this.availableCountries = availableCountries;
    }

    public List<SelectItem> getAvailableCountries() {
        return availableCountries;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
