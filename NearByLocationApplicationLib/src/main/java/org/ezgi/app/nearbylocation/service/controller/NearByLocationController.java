package org.ezgi.app.nearbylocation.service.controller;

import org.ezgi.app.nearbylocation.search.dto.NearByLocationInfoDTO;
import org.ezgi.app.nearbylocation.service.PlaceInfoLocationService;
import org.ezgi.app.nearbylocation.service.dto.PlaceInfoLocationDTO;
import org.ezgi.app.nearbylocation.service.dto.PlaceLocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/place/nearbysearch")
public class NearByLocationController {
    private final PlaceInfoLocationService m_PlaceInfoLocationService;

    public NearByLocationController(PlaceInfoLocationService placeInfoLocationService)
    {
        m_PlaceInfoLocationService = placeInfoLocationService;
    }


    @GetMapping("")
    public PlaceLocationDTO findLocationInfo(@RequestParam(name = "latitude") double latitude, @RequestParam(name = "longitude") double longitude, @RequestParam(name = "radius") double radius)
    {
        return m_PlaceInfoLocationService.findLocationByLatitudeAndLongitudeAndLatitude(latitude, longitude, radius);
    }
}
