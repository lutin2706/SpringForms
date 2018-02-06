package be.superteam.springmvcforms.service;

import be.superteam.springmvcforms.model.Trip;

import java.util.List;
import java.util.UUID;

public interface TripService {

    void create(Trip trip);

    Trip get(Long id);

    void update(Trip trip);

    void delete(Long id);

    List<Trip> getList();
}
