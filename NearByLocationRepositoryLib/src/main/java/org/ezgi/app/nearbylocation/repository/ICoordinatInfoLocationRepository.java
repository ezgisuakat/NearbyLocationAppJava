package org.ezgi.app.nearbylocation.repository;

import org.ezgi.app.nearbylocation.entity.CoordinatInfoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICoordinatInfoLocationRepository extends CrudRepository<CoordinatInfoLocation, Integer> {

    boolean existsByLatitudeAndLongitudeAndRadius(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radius") double radius);
    Optional<CoordinatInfoLocation> findByLatitudeAndLongitudeAndRadius(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("radius") double radius);
}
