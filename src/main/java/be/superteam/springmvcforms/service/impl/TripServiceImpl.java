package be.superteam.springmvcforms.service.impl;

import be.superteam.springmvcforms.model.Trip;
import be.superteam.springmvcforms.repository.TripRepo;
import be.superteam.springmvcforms.service.TripService;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Service
public class TripServiceImpl implements TripService {

    private TripRepo tripRepo;

    public TripServiceImpl(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    @Override
    public void create(Trip trip) {
        tripRepo.save(trip);
    }

    @Override
    public Trip get(Long id) {
        return tripRepo.getOne(id);
    }

    @Override
    public void update(Trip trip) {
        tripRepo.save(trip);
    }

    @Override
    public void delete(Long id) {
       tripRepo.delete(id);
    }

    @Override
    public List<Trip> getList() {
        return tripRepo.findAll();
    }
}
