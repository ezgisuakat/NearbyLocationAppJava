package org.ezgi.app.nearbylocation.service.mapper;

import org.ezgi.app.nearbylocation.entity.CoordinatInfoLocation;
import org.ezgi.app.nearbylocation.entity.PlaceInfoLocation;
import org.ezgi.app.nearbylocation.search.dto.NearByLocationDTO;
import org.ezgi.app.nearbylocation.search.dto.NearByLocationInfoDTO;
import org.ezgi.app.nearbylocation.service.dto.PlaceInfoLocationDTO;
import org.ezgi.app.nearbylocation.service.dto.PlaceLocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(implementationName = "PlaceInfoLocationMapperImpl",  componentModel = "spring")
public interface IPlaceInfoLocationMapper {
    PlaceInfoLocation toPlaceInfoLocation(PlaceInfoLocationDTO placeInfoLocationDTO);

    PlaceInfoLocationDTO toPlaceInfoLocationDTO(PlaceInfoLocation placeInfoLocation);

    @Mapping(source = "placeInfoLocations", target = "placeInfoLocationDTOs")
    PlaceLocationDTO toPlaceLocationDTO(CoordinatInfoLocation coordinatInfoLocation);

    @Mapping(source = "results", target = "placeInfoLocationDTOs")
    PlaceLocationDTO toPlaceLocationDTO(NearByLocationDTO nearByLocationDTO);

    Set<PlaceInfoLocation> toPlaceInfoLocation(List<NearByLocationInfoDTO> nearByLocationInfoDTOS);


    default CoordinatInfoLocation toCoordinatInfoLocation(double latitude, double longitude, double radius, NearByLocationDTO nearbyLocation)
    {
        var cil = new CoordinatInfoLocation();

        cil.latitude = latitude;
        cil.longitude = longitude;
        cil.radius = radius;
        cil.placeInfoLocations = toPlaceInfoLocation(nearbyLocation.results);

        return cil;
    }

}
