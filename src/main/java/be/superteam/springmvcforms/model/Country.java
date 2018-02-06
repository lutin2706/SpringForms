package be.superteam.springmvcforms.model;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

//    @OneToMany(mappedBy="country", fetch=FetchType.LAZY)  ==> pas obligatoire
//    private Set<Trip> trips = new HashSet<>();

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Trip> getTrips() {
//        return trips;
//    }
//
//    public void setTrips(Set<Trip> trips) {
//        this.trips = trips;
//    }
}
