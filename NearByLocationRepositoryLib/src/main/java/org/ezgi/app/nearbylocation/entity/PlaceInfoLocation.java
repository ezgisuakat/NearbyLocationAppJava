package org.ezgi.app.nearbylocation.entity;

import jakarta.persistence.*;
import org.ezgi.app.nearbylocation.entity.classes.Geometry;
import org.ezgi.app.nearbylocation.entity.classes.PlusCode;
import org.ezgi.app.nearbylocation.entity.classes.OpeningHours;
import org.ezgi.app.nearbylocation.entity.classes.Photo;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "place_info_locations")
public class PlaceInfoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "place_id")
    public int id;

    public String business_status;
    public String icon;
    public String icon_background_color;
    public String icon_mask_base_uri;
    public String name;
    public String place_id;
    public int price_level;
    public double rating;
    public String reference;
    public String scope;
    public ArrayList<String> types;
    public int user_ratings_total;
    public String vicinity;

    public Geometry geometry;

    public PlusCode plus_code;

    public OpeningHours opening_hours;

    public ArrayList<Photo> photos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinat_id", nullable = false)
    public CoordinatInfoLocation coordinatInfoLocation;

    @Override
    public int hashCode()
    {
        return Objects.hash(id, geometry);
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof PlaceInfoLocation p && Objects.equals(id, p.id)
                                                    && Objects.equals(geometry, p.geometry);
    }
}

