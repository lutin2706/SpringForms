package be.superteam.springmvcforms.controller;

import be.superteam.springmvcforms.model.Country;
import be.superteam.springmvcforms.model.SelectItem;
import be.superteam.springmvcforms.model.Trip;
import be.superteam.springmvcforms.model.TripForm;
import be.superteam.springmvcforms.service.CountryService;
import be.superteam.springmvcforms.service.impl.TripServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TripController {

    private TripServiceImpl tripService;

    private CountryService countryService;

    public TripController(TripServiceImpl tripService, CountryService countryService) {
        this.tripService = tripService;
        this.countryService = countryService;
    }

    @GetMapping("/trips")
    public String getTrips(Model model) {
        model.addAttribute("tripList", fromTripToTripForm(tripService.getList()));
        return "trip";
    }

    @GetMapping("/trip")
    public String getTrip(Model model) {
        TripForm trip = new TripForm();
        trip.setAvailableCountries(fromCountryToSelectItem(countryService.getList()));
        model.addAttribute("trip",trip );
        return "trip";
    }

    @GetMapping("/trip/{id}")
    public String getTrip(@PathVariable("id") Long id, Model model) {
        Trip trip = tripService.get(id);
        TripForm tripForm = new TripForm(trip.getId(), trip.getName(), trip.getDuration(), trip.getDepartureDate(), trip.getCountry().getId(), trip.getCountry().getName(), trip.getImage());
        tripForm.setId(trip.getId());
        tripForm.setAvailableCountries(fromCountryToSelectItem(countryService.getList()));
        model.addAttribute("trip",tripForm );
        return "trip";
    }

    @PostMapping("/trip")
    public String saveTrip(@Valid TripForm trip, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            trip.setAvailableCountries(fromCountryToSelectItem(countryService.getList()));
            return "trip";
        }

        if (trip.getId() != null) {
            Country country = new Country(trip.getCountryName());
            country.setId(trip.getCountryId());
            Trip tripToUpdate = new Trip(trip.getName(), trip.getDuration(), trip.getDepartureDate(), country, trip.getImage());
            tripToUpdate.setId(trip.getId());
            tripService.update(tripToUpdate);
        } else {
            Country country = new Country(trip.getCountryName());
            country.setId(trip.getCountryId());
            tripService.create(new Trip(trip.getName(), trip.getDuration(), trip.getDepartureDate(), country, trip.getImage()));
        }
        return "redirect:/trips";
    }

    @PostMapping("/trip/delete")
    public String deleteTrip(@RequestParam Long id) {
        tripService.delete(id);
        return "redirect:/trips";
    }

    // TODO : convertir en stream
    private List<SelectItem> fromCountryToSelectItem(List<Country> countries) {
        List<SelectItem> list = new ArrayList<>();
        for (Country country : countries) {
            SelectItem se = new SelectItem(country.getId(), country.getName());
            list.add(se);
        }
        return list;
    }

    private List<TripForm> fromTripToTripForm(List<Trip> trips) {
        List<TripForm> list = new ArrayList<>();
        for (Trip trip : trips) {
            TripForm se = new TripForm(trip.getId(), trip.getName(),trip.getDuration(), trip.getDepartureDate(), trip.getCountry().getId(), trip.getCountry().getName(), trip.getImage());
            list.add(se);
        }
        return list;
    }
}
