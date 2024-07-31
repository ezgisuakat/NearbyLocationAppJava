package org.ezgi.app.nearbylocation.dal;

import org.ezgi.app.nearbylocation.entity.CoordinatInfoLocation;
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


    public boolean existLocationByLatitudeAndLongitudeAndRadius(double latitude, double longitude, double radius)
    {
        try {
            return m_coordinatInfoLocationRepository.existsByLatitudeAndLongitudeAndRadius(latitude, longitude, radius);
        }
        catch(Throwable ex)
        {
            throw new RuntimeException("NearByLocationRepositoryLib.existLocation", ex);
        }
    }

    public Optional<CoordinatInfoLocation> findLocationInfoByLatitudeAndLongitudeAndLatitude(double latitude, double longitude, double radius)
    {
        try {
            return m_coordinatInfoLocationRepository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius);
        }
        catch(Throwable ex)
        {
            throw new RuntimeException("NearByLocationRepositoryLib.findLocation", ex);
        }
    }

    public CoordinatInfoLocation saveCoordinatInfoLocation(CoordinatInfoLocation coordinatInfoLocation)
    {
        try {
            return m_coordinatInfoLocationRepository.save(coordinatInfoLocation);
        }
        catch(Throwable ex)
        {
            throw new RuntimeException("NearByLocationRepositoryLib.saveCoordinatInfoLocation:" + ex.getMessage());
        }
    }
    //...
}

