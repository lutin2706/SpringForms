package be.superteam.springmvcforms.repository;

import be.superteam.springmvcforms.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip, Long> {
}
