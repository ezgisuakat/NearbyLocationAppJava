package org.ezgi.app.nearbylocation.repository;

import org.ezgi.app.nearbylocation.entity.PlaceInfoLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoLocationRepository extends CrudRepository<PlaceInfoLocation, Integer> {

    /*
    @Query("from PlaceInfoLocation where p.coordinat_id.latitude : latitude and p.coordinat_id.longitude : longitude and p.coordinat_id.radius : radius")
    Optional<PlaceInfoLocation> findByLatitudeAndLongitudeAndRadius(@Param("latitude") double latitude,
                                                                    @Param("longitude") double longitude,
                                                                    @Param("radius") double radius);
    */

}
