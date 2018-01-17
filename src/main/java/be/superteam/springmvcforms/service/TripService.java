package be.superteam.springmvcforms.service;

import be.superteam.springmvcforms.model.Trip;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Service
public class TripService {
    private Map<UUID, Trip> trips = new HashMap<UUID, Trip>();

    @PostConstruct
    public void initializeDB() {
        UUID uuid1 = UUID.randomUUID();
        trips.put(uuid1, new Trip(uuid1,"Bali en sandalettes", 12, LocalDate.of(2018,02,10),4));
        UUID uuid2 = UUID.randomUUID();
        trips.put(uuid2, new Trip(uuid2,"Les vins de Porto", 3, LocalDate.of(2018,04,02),1));
        UUID uuid3 = UUID.randomUUID();
        trips.put(uuid3, new Trip(uuid3,"Torrémolinos pour les beaufs", 7, LocalDate.of(2018,07,01), 2));
    }

    public void create(Trip trip) {
        UUID uuid = UUID.randomUUID();
        trip.setUuid(uuid);
        trips.put(uuid, trip);
    }

    public Trip get(UUID uuid) {
        return trips.get(uuid);
    }

    public void update(Trip trip) {
        trips.put(trip.getUuid(), trip);
    }

    public void delete(UUID uuid) {
       trips.remove(uuid);
    }

    public List<Trip> getList() {
        return new ArrayList<>(trips.values());
    }
}
