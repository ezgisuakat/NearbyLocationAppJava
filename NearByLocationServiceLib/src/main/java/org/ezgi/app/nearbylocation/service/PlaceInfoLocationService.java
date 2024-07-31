package org.ezgi.app.nearbylocation.service;

import org.ezgi.app.nearbylocation.dal.PlaceInfoLocationDataHelper;
import org.ezgi.app.nearbylocation.search.NearByLocationInfoSearchHelper;
import org.ezgi.app.nearbylocation.service.dto.PlaceLocationDTO;
import org.ezgi.app.nearbylocation.service.mapper.IPlaceInfoLocationMapper;
import org.springframework.stereotype.Service;

@Service
public class PlaceInfoLocationService {
    private final PlaceInfoLocationDataHelper m_placeInfoLocationDataHelper;
    private final IPlaceInfoLocationMapper m_placeInfoLocationMapper;
    private final NearByLocationInfoSearchHelper m_nearByLocationInfoSearchHelper;

    public PlaceInfoLocationService(PlaceInfoLocationDataHelper placeInfoLocationDataHelper,
                                   IPlaceInfoLocationMapper placeInfoLocationMapper,
                                   NearByLocationInfoSearchHelper nearByLocationInfoSearchHelper)
    {
        m_placeInfoLocationDataHelper = placeInfoLocationDataHelper;
        m_placeInfoLocationMapper = placeInfoLocationMapper;
        m_nearByLocationInfoSearchHelper = nearByLocationInfoSearchHelper;
    }


    private PlaceLocationDTO exitsInDbCallback(double latitude, double longitude, double radius)
    {
        var pil = m_placeInfoLocationDataHelper.findLocationInfoByLatitudeAndLongitudeAndLatitude(latitude, longitude, radius).get();

        return m_placeInfoLocationMapper.toPlaceLocationDTO(pil);
    }

    private PlaceLocationDTO notExistsInDbCallback(double latitude, double longitude, double radius)
    {
        var nearbyLocation =  m_nearByLocationInfoSearchHelper.findNearByLocationByCoordinate(latitude, longitude, radius).get();
        nearbyLocation.results.forEach(val -> System.out.println(val.business_status));
        var cil = m_placeInfoLocationDataHelper.saveCoordinatInfoLocation(m_placeInfoLocationMapper.toCoordinatInfoLocation(latitude, longitude, radius, nearbyLocation));

        return m_placeInfoLocationMapper.toPlaceLocationDTO(nearbyLocation);
    }


    public PlaceLocationDTO findLocationByLatitudeAndLongitudeAndRadius(double latitude, double longitude, double radius)
    {

        return m_placeInfoLocationDataHelper.existLocationByLatitudeAndLongitudeAndRadius(latitude, longitude, radius) ? exitsInDbCallback(latitude, longitude, radius) : notExistsInDbCallback(latitude, longitude, radius);
    }

    //...
}
