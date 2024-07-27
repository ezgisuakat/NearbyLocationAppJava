package org.ezgi.app.nearbylocation.entity;

import java.util.Objects;
import java.util.Set;


import jakarta.persistence.*;

@Entity
@Table(name = "coordinat_info_locations")
public class CoordinatInfoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coordinat_id")
    public int id;

    public double latitude;
    public double longitude;
    public double radius;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "placeInfoLocation", cascade = CascadeType.ALL)
    public Set<PlaceInfoLocation> placeInfoLocations;

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longitude, radius);
    }

    @Override
    public boolean equals(Object other) {
            return other instanceof CoordinatInfoLocation c && Objects.equals(id, c.id)
                                                            && Objects.equals(latitude, c.latitude)
                                                            && Objects.equals(longitude, c.longitude)
                                                            && Objects.equals(radius, c.radius);
        }
    }


