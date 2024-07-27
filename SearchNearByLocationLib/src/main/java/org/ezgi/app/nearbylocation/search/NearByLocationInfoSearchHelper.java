package org.ezgi.app.nearbylocation.search;

import org.ezgi.app.nearbylocation.search.dto.NearByLocationDTO;
import org.ezgi.app.nearbylocation.search.dto.NearByLocationInfoDTO;
import org.springframework.stereotype.Component;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class NearByLocationInfoSearchHelper {
    private final RestTemplate m_restTemplate;

    private final String m_locationUrlTemplate = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword=cruise&location=%f,%f&radius=%f&type=restaurant&key=xxx";


    public NearByLocationInfoSearchHelper(RestTemplate restTemplate) {
        this.m_restTemplate = restTemplate;
    }

    public Optional<NearByLocationDTO> findNearByLocationByCoordinate(double latitude, double longitude, double radius)
    {
        var nld = m_restTemplate.getForObject(String.format(m_locationUrlTemplate, latitude, longitude, radius), NearByLocationDTO.class);

        return Optional.ofNullable(nld);
    }


    public Iterable<NearByLocationInfoDTO> findNearByLocationInfoSearch(double latitude, double longitude, double radius)
    {
        var nblOpt = findNearByLocationByCoordinate(latitude, longitude, radius);

        if(nblOpt.isEmpty())
            return new ArrayList<>();

        return nblOpt.get().results;
    }
}

