package org.ezgi.app.nearbylocation.dal;

import org.ezgi.app.nearbylocation.entity.CoordinatInfoLocation;
import org.ezgi.app.nearbylocation.entity.PlaceInfoLocation;
import org.ezgi.app.nearbylocation.repository.ICoordinatInfoLocationRepository;
import org.ezgi.app.nearbylocation.repository.IPlaceInfoLocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlaceInfoLocationDataHelper {
    private final ICoordinatInfoLocationRepository m_coordinatInfoLocationRepository;

    private final IPlaceInfoLocationRepository m_placeInfoLocationRepository;


    public PlaceInfoLocationDataHelper(ICoordinatInfoLocationRepository coordinatInfoLocationRepository,
                                       IPlaceInfoLocationRepository placeInfoLocationRepository)
    {
        m_coordinatInfoLocationRepository = coordinatInfoLocationRepository;
        m_placeInfoLocationRepository = placeInfoLocationRepository;
    }

    public PlaceInfoLocation savePlaceInfoLocation(PlaceInfoLocation placeInfoLocation)
    {
        return m_placeInfoLocationRepository.save(placeInfoLocation);
    }

    public boolean existByLocationByLatitudeAndLongitudeAndRadius(double langitude, double longitude, double radius)
    {
        return m_coordinatInfoLocationRepository.existsByLangitudeAndLongitudeAndRadius(langitude, longitude, radius);
    }

    public Optional<CoordinatInfoLocation> findLocationInfoByLatitudeAndLongitudeAndLatitude(double latitude, double longitude, double radius)
    {
        return m_coordinatInfoLocationRepository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius);
    }

    public void saveCoordinatInfoLocation(CoordinatInfoLocation coordinatInfoLocation)
    {
        m_coordinatInfoLocationRepository.save(coordinatInfoLocation);
    }
    //...
}

