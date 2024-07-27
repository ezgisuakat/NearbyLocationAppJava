package org.ezgi.app.nearbylocation.repository;

import org.ezgi.app.nearbylocation.entity.CoordinatInfoLocation;
import org.ezgi.app.nearbylocation.entity.PlaceInfoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoordinatInfoLocationRepository extends CrudRepository<CoordinatInfoLocation, Integer> {

    boolean existsByLangitudeAndLongitudeAndRadius(double langitude, double longitude, double radius);
    Optional<CoordinatInfoLocation> findByLatitudeAndLongitudeAndRadius(double latitude, double longitude, double radius);
}
