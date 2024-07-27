package org.ezgi.app.nearbylocation.search.dto;

import org.ezgi.app.nearbylocation.entity.PlaceInfoLocation;
import org.ezgi.app.nearbylocation.search.dto.classes.Geometry;
import org.ezgi.app.nearbylocation.search.dto.classes.OpeningHours;
import org.ezgi.app.nearbylocation.search.dto.classes.Photo;
import org.ezgi.app.nearbylocation.search.dto.classes.PlusCode;

import java.util.ArrayList;
import java.util.Objects;

public class NearByLocationInfoDTO {
    public int id;

    public String business_status;
    public Geometry geometry;
    public String icon;
    public String icon_background_color;
    public String icon_mask_base_uri;
    public String name;
    public OpeningHours opening_hours;
    public ArrayList<Photo> photos;
    public String place_id;
    public PlusCode plus_code;
    public int price_level;
    public double rating;
    public String reference;
    public String scope;
    public ArrayList<String> types;
    public int user_ratings_total;
    public String vicinity;

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

