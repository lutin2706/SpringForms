package be.superteam.springmvcforms.controller;

import be.superteam.springmvcforms.model.Trip;
import be.superteam.springmvcforms.model.UserForm;
import be.superteam.springmvcforms.service.CountryService;
import be.superteam.springmvcforms.service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class TripController {

    private TripService tripService;

    private CountryService countryService;

    public TripController(TripService tripService, CountryService countryService) {
        this.tripService = tripService;
        this.countryService = countryService;
    }

    @GetMapping("/trips")
    public String getTrips(Model model) {
        model.addAttribute("tripList", tripService.getList());
        return "trip";
    }

    @PostMapping("/trip")
    public String saveTrip(@Valid Trip trip, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            trip.setCountriesAvailable(countryService.getAvailableCountries());
            return "trip";
        }

        if (trip.getUuid() != null) {
            tripService.update(trip);
        } else {
            tripService.create(trip);
        }
        return "redirect:/trips";
    }

    @GetMapping("/trip")
    public String getTrip(Model model) {
        Trip trip = new Trip();
        trip.setCountriesAvailable(countryService.getAvailableCountries());
        model.addAttribute("trip",trip );
        return "trip";
    }

    @GetMapping("/trip/{id}")
    public String getTrip(@PathVariable("id") UUID id, Model model) {
        Trip trip = tripService.get(id);
        trip.setCountriesAvailable(countryService.getAvailableCountries());
        model.addAttribute("trip",trip );
        return "trip";
    }

    @PostMapping("/trip/delete")
    public String deleteTrip(@RequestParam UUID id) {
        tripService.delete(id);
        return "redirect:/trips";
    }
}
