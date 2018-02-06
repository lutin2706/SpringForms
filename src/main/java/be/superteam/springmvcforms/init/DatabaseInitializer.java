package be.superteam.springmvcforms.init;


import be.superteam.springmvcforms.model.Country;
import be.superteam.springmvcforms.model.Trip;
import be.superteam.springmvcforms.repository.CountryRepo;
import be.superteam.springmvcforms.repository.TripRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements InitializingBean {

    private Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);
    private TripRepo tripRepo;
    private CountryRepo countryRepo;

    public DatabaseInitializer(TripRepo tripRepo, CountryRepo countryRepo) {

        this.tripRepo = tripRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Country portugal = new Country("Portugal");
        Country espagne = new Country("Espagne");
        Country italie = new Country("Italie");
        Country indonesie = new Country("Indonésie");

        countryRepo.save(portugal);
        countryRepo.save(espagne);
        countryRepo.save(italie);
        countryRepo.save(indonesie);

        // Aller chercher les objets avec une pagination
        // tripRepo.findAll(new PageRequest(3, 20));

        Trip lisbon = new Trip("Sur les rives du Tage", 2, LocalDate.now().plusDays(12), portugal, "http://static.abcroisiere.com/images/fr/escales/escale,Lisbonne-Portugal_zoom,PT,LIS,30399.jpg");
        Trip seville = new Trip("Les merveilles de Seville", 3, LocalDate.now().plusDays(10), espagne, "http://www.geo.fr/var/geo/storage/images/voyages/guides-de-voyage/europe/espagne/andalousie/seville/120208-15-fre-FR/seville.jpg");
        Trip florence = new Trip("La belle Florence", 4, LocalDate.now().plusDays(5), italie, "https://media.cntraveler.com/photos/57719b2a4a3399cb31f9da7a/master/pass/florence-01-duomo-GettyImages-504655313.jpg");

        // CREATE
        tripRepo.save(lisbon);
        tripRepo.save(seville);
        tripRepo.save(florence);

//        // READ
//        List<Trip> trips = tripRepo.findAll();
//        for (Trip t : trips) {
//            logger.warn(t.toString());
//        }
//
//        // FIND
//        Trip example = new Trip();
//        example.setDestination("London");
//        Trip found = tripRepo.findOne((Example.of(example, ExampleMatcher.matchingAny())));
//        logger.warn(found.toString());
//
//        found.setDestination("Dundee");
//        tripRepo.save(found);
//
//        Trip foundUpdated = tripRepo.findOne(1L);
//        logger.warn(foundUpdated.toString());
//
//        // CUSTOM REQUEST WITH METHOD NAME
//        List<Trip> dundees = tripRepo.findAllByDestination("Dundee");
//        logger.warn("All destinations Dundee: " + dundees.toString());
//
//        List<Trip> thisMonth = tripRepo.findAllByDepartureDateBeforeOrderByDaysDesc(LocalDate.now().plusDays(10));
//        logger.warn("All destinations starting in next 10 days: " + thisMonth.toString());
//
//        // CUSTOM REQUEST USING JPQL
//        List<Trip> twoDays = tripRepo.findTwoDaysTrips();
//        logger.warn("All trips of 2 days: " + twoDays.toString());
//
//        List<Trip> twoDaysBis = tripRepo.findTripsByDays(10);
//        logger.warn("All trips of 10 days: " + twoDaysBis);
//
//        // DELETE
//        tripRepo.delete(1L);
    }
}
