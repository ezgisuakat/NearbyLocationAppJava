package org.ezgi.app.nearbylocation.service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.ezgi.app.nearbylocation.entity.CoordinatInfoLocation;
import org.ezgi.app.nearbylocation.entity.PlaceInfoLocation;
import org.ezgi.app.nearbylocation.entity.classes.Location;
import org.ezgi.app.nearbylocation.entity.classes.OpeningHours;
import org.ezgi.app.nearbylocation.entity.classes.Photo;
import org.ezgi.app.nearbylocation.entity.classes.Southwest;
import org.ezgi.app.nearbylocation.entity.classes.Viewport;
import org.ezgi.app.nearbylocation.search.dto.NearByLocationDTO;
import org.ezgi.app.nearbylocation.search.dto.NearByLocationInfoDTO;
import org.ezgi.app.nearbylocation.search.dto.classes.Geometry;
import org.ezgi.app.nearbylocation.search.dto.classes.Northeast;
import org.ezgi.app.nearbylocation.search.dto.classes.PlusCode;
import org.ezgi.app.nearbylocation.service.dto.PlaceInfoLocationDTO;
import org.ezgi.app.nearbylocation.service.dto.PlaceLocationDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-28T00:35:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class PlaceInfoLocationMapperImpl implements IPlaceInfoLocationMapper {

    @Override
    public PlaceInfoLocation toPlaceInfoLocation(PlaceInfoLocationDTO placeInfoLocationDTO) {
        if ( placeInfoLocationDTO == null ) {
            return null;
        }

        PlaceInfoLocation placeInfoLocation = new PlaceInfoLocation();

        placeInfoLocation.id = placeInfoLocationDTO.id;
        placeInfoLocation.business_status = placeInfoLocationDTO.business_status;
        placeInfoLocation.icon = placeInfoLocationDTO.icon;
        placeInfoLocation.icon_background_color = placeInfoLocationDTO.icon_background_color;
        placeInfoLocation.icon_mask_base_uri = placeInfoLocationDTO.icon_mask_base_uri;
        placeInfoLocation.name = placeInfoLocationDTO.name;
        placeInfoLocation.place_id = placeInfoLocationDTO.place_id;
        placeInfoLocation.price_level = placeInfoLocationDTO.price_level;
        placeInfoLocation.rating = placeInfoLocationDTO.rating;
        placeInfoLocation.reference = placeInfoLocationDTO.reference;
        placeInfoLocation.scope = placeInfoLocationDTO.scope;
        ArrayList<String> arrayList = placeInfoLocationDTO.types;
        if ( arrayList != null ) {
            placeInfoLocation.types = new ArrayList<String>( arrayList );
        }
        placeInfoLocation.user_ratings_total = placeInfoLocationDTO.user_ratings_total;
        placeInfoLocation.vicinity = placeInfoLocationDTO.vicinity;
        placeInfoLocation.geometry = geometryToGeometry( placeInfoLocationDTO.geometry );
        placeInfoLocation.plus_code = plusCodeToPlusCode( placeInfoLocationDTO.plus_code );
        placeInfoLocation.opening_hours = openingHoursToOpeningHours( placeInfoLocationDTO.opening_hours );
        placeInfoLocation.photos = photoArrayListToPhotoArrayList( placeInfoLocationDTO.photos );

        return placeInfoLocation;
    }

    @Override
    public PlaceInfoLocationDTO toPlaceInfoLocationDTO(PlaceInfoLocation placeInfoLocation) {
        if ( placeInfoLocation == null ) {
            return null;
        }

        PlaceInfoLocationDTO placeInfoLocationDTO = new PlaceInfoLocationDTO();

        placeInfoLocationDTO.id = placeInfoLocation.id;
        placeInfoLocationDTO.business_status = placeInfoLocation.business_status;
        placeInfoLocationDTO.geometry = geometryToGeometry1( placeInfoLocation.geometry );
        placeInfoLocationDTO.icon = placeInfoLocation.icon;
        placeInfoLocationDTO.icon_background_color = placeInfoLocation.icon_background_color;
        placeInfoLocationDTO.icon_mask_base_uri = placeInfoLocation.icon_mask_base_uri;
        placeInfoLocationDTO.name = placeInfoLocation.name;
        placeInfoLocationDTO.opening_hours = openingHoursToOpeningHours1( placeInfoLocation.opening_hours );
        placeInfoLocationDTO.photos = photoArrayListToPhotoArrayList1( placeInfoLocation.photos );
        placeInfoLocationDTO.place_id = placeInfoLocation.place_id;
        placeInfoLocationDTO.plus_code = plusCodeToPlusCode1( placeInfoLocation.plus_code );
        placeInfoLocationDTO.price_level = placeInfoLocation.price_level;
        placeInfoLocationDTO.rating = placeInfoLocation.rating;
        placeInfoLocationDTO.reference = placeInfoLocation.reference;
        placeInfoLocationDTO.scope = placeInfoLocation.scope;
        ArrayList<String> arrayList1 = placeInfoLocation.types;
        if ( arrayList1 != null ) {
            placeInfoLocationDTO.types = new ArrayList<String>( arrayList1 );
        }
        placeInfoLocationDTO.user_ratings_total = placeInfoLocation.user_ratings_total;
        placeInfoLocationDTO.vicinity = placeInfoLocation.vicinity;

        return placeInfoLocationDTO;
    }

    @Override
    public PlaceLocationDTO toPlaceLocationDTO(CoordinatInfoLocation coordinatInfoLocation) {
        if ( coordinatInfoLocation == null ) {
            return null;
        }

        PlaceLocationDTO placeLocationDTO = new PlaceLocationDTO();

        placeLocationDTO.placeInfoLocationDTOs = placeInfoLocationSetToPlaceInfoLocationDTOList( coordinatInfoLocation.placeInfoLocations );

        return placeLocationDTO;
    }

    @Override
    public PlaceLocationDTO toPlaceLocationDTO(NearByLocationDTO nearByLocationDTO) {
        if ( nearByLocationDTO == null ) {
            return null;
        }

        PlaceLocationDTO placeLocationDTO = new PlaceLocationDTO();

        placeLocationDTO.placeInfoLocationDTOs = nearByLocationInfoDTOArrayListToPlaceInfoLocationDTOList( nearByLocationDTO.results );

        return placeLocationDTO;
    }

    @Override
    public Set<PlaceInfoLocation> toPlaceInfoLocation(List<NearByLocationInfoDTO> nearByLocationInfoDTOS) {
        if ( nearByLocationInfoDTOS == null ) {
            return null;
        }

        Set<PlaceInfoLocation> set = new LinkedHashSet<PlaceInfoLocation>( Math.max( (int) ( nearByLocationInfoDTOS.size() / .75f ) + 1, 16 ) );
        for ( NearByLocationInfoDTO nearByLocationInfoDTO : nearByLocationInfoDTOS ) {
            set.add( nearByLocationInfoDTOToPlaceInfoLocation( nearByLocationInfoDTO ) );
        }

        return set;
    }

    protected Location locationToLocation(org.ezgi.app.nearbylocation.search.dto.classes.Location location) {
        if ( location == null ) {
            return null;
        }

        Location location1 = new Location();

        location1.lat = location.lat;
        location1.lng = location.lng;

        return location1;
    }

    protected org.ezgi.app.nearbylocation.entity.classes.Northeast northeastToNortheast(Northeast northeast) {
        if ( northeast == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.entity.classes.Northeast northeast1 = new org.ezgi.app.nearbylocation.entity.classes.Northeast();

        northeast1.lat = northeast.lat;
        northeast1.lng = northeast.lng;

        return northeast1;
    }

    protected Southwest southwestToSouthwest(org.ezgi.app.nearbylocation.search.dto.classes.Southwest southwest) {
        if ( southwest == null ) {
            return null;
        }

        Southwest southwest1 = new Southwest();

        southwest1.lat = southwest.lat;
        southwest1.lng = southwest.lng;

        return southwest1;
    }

    protected Viewport viewportToViewport(org.ezgi.app.nearbylocation.search.dto.classes.Viewport viewport) {
        if ( viewport == null ) {
            return null;
        }

        Viewport viewport1 = new Viewport();

        viewport1.northeast = northeastToNortheast( viewport.northeast );
        viewport1.southwest = southwestToSouthwest( viewport.southwest );

        return viewport1;
    }

    protected org.ezgi.app.nearbylocation.entity.classes.Geometry geometryToGeometry(Geometry geometry) {
        if ( geometry == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.entity.classes.Geometry geometry1 = new org.ezgi.app.nearbylocation.entity.classes.Geometry();

        geometry1.location = locationToLocation( geometry.location );
        geometry1.viewport = viewportToViewport( geometry.viewport );

        return geometry1;
    }

    protected org.ezgi.app.nearbylocation.entity.classes.PlusCode plusCodeToPlusCode(PlusCode plusCode) {
        if ( plusCode == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.entity.classes.PlusCode plusCode1 = new org.ezgi.app.nearbylocation.entity.classes.PlusCode();

        plusCode1.compound_code = plusCode.compound_code;
        plusCode1.global_code = plusCode.global_code;

        return plusCode1;
    }

    protected OpeningHours openingHoursToOpeningHours(org.ezgi.app.nearbylocation.search.dto.classes.OpeningHours openingHours) {
        if ( openingHours == null ) {
            return null;
        }

        OpeningHours openingHours1 = new OpeningHours();

        openingHours1.open_now = openingHours.open_now;

        return openingHours1;
    }

    protected Photo photoToPhoto(org.ezgi.app.nearbylocation.search.dto.classes.Photo photo) {
        if ( photo == null ) {
            return null;
        }

        Photo photo1 = new Photo();

        photo1.height = photo.height;
        ArrayList<String> arrayList = photo.html_attributions;
        if ( arrayList != null ) {
            photo1.html_attributions = new ArrayList<String>( arrayList );
        }
        photo1.photo_reference = photo.photo_reference;
        photo1.width = photo.width;

        return photo1;
    }

    protected ArrayList<Photo> photoArrayListToPhotoArrayList(ArrayList<org.ezgi.app.nearbylocation.search.dto.classes.Photo> arrayList) {
        if ( arrayList == null ) {
            return null;
        }

        ArrayList<Photo> arrayList1 = new ArrayList<Photo>();
        for ( org.ezgi.app.nearbylocation.search.dto.classes.Photo photo : arrayList ) {
            arrayList1.add( photoToPhoto( photo ) );
        }

        return arrayList1;
    }

    protected org.ezgi.app.nearbylocation.search.dto.classes.Location locationToLocation1(Location location) {
        if ( location == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.search.dto.classes.Location location1 = new org.ezgi.app.nearbylocation.search.dto.classes.Location();

        location1.lat = location.lat;
        location1.lng = location.lng;

        return location1;
    }

    protected Northeast northeastToNortheast1(org.ezgi.app.nearbylocation.entity.classes.Northeast northeast) {
        if ( northeast == null ) {
            return null;
        }

        Northeast northeast1 = new Northeast();

        northeast1.lat = northeast.lat;
        northeast1.lng = northeast.lng;

        return northeast1;
    }

    protected org.ezgi.app.nearbylocation.search.dto.classes.Southwest southwestToSouthwest1(Southwest southwest) {
        if ( southwest == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.search.dto.classes.Southwest southwest1 = new org.ezgi.app.nearbylocation.search.dto.classes.Southwest();

        southwest1.lat = southwest.lat;
        southwest1.lng = southwest.lng;

        return southwest1;
    }

    protected org.ezgi.app.nearbylocation.search.dto.classes.Viewport viewportToViewport1(Viewport viewport) {
        if ( viewport == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.search.dto.classes.Viewport viewport1 = new org.ezgi.app.nearbylocation.search.dto.classes.Viewport();

        viewport1.northeast = northeastToNortheast1( viewport.northeast );
        viewport1.southwest = southwestToSouthwest1( viewport.southwest );

        return viewport1;
    }

    protected Geometry geometryToGeometry1(org.ezgi.app.nearbylocation.entity.classes.Geometry geometry) {
        if ( geometry == null ) {
            return null;
        }

        Geometry geometry1 = new Geometry();

        geometry1.location = locationToLocation1( geometry.location );
        geometry1.viewport = viewportToViewport1( geometry.viewport );

        return geometry1;
    }

    protected org.ezgi.app.nearbylocation.search.dto.classes.OpeningHours openingHoursToOpeningHours1(OpeningHours openingHours) {
        if ( openingHours == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.search.dto.classes.OpeningHours openingHours1 = new org.ezgi.app.nearbylocation.search.dto.classes.OpeningHours();

        openingHours1.open_now = openingHours.open_now;

        return openingHours1;
    }

    protected org.ezgi.app.nearbylocation.search.dto.classes.Photo photoToPhoto1(Photo photo) {
        if ( photo == null ) {
            return null;
        }

        org.ezgi.app.nearbylocation.search.dto.classes.Photo photo1 = new org.ezgi.app.nearbylocation.search.dto.classes.Photo();

        photo1.height = photo.height;
        ArrayList<String> arrayList = photo.html_attributions;
        if ( arrayList != null ) {
            photo1.html_attributions = new ArrayList<String>( arrayList );
        }
        photo1.photo_reference = photo.photo_reference;
        photo1.width = photo.width;

        return photo1;
    }

    protected ArrayList<org.ezgi.app.nearbylocation.search.dto.classes.Photo> photoArrayListToPhotoArrayList1(ArrayList<Photo> arrayList) {
        if ( arrayList == null ) {
            return null;
        }

        ArrayList<org.ezgi.app.nearbylocation.search.dto.classes.Photo> arrayList1 = new ArrayList<org.ezgi.app.nearbylocation.search.dto.classes.Photo>();
        for ( Photo photo : arrayList ) {
            arrayList1.add( photoToPhoto1( photo ) );
        }

        return arrayList1;
    }

    protected PlusCode plusCodeToPlusCode1(org.ezgi.app.nearbylocation.entity.classes.PlusCode plusCode) {
        if ( plusCode == null ) {
            return null;
        }

        PlusCode plusCode1 = new PlusCode();

        plusCode1.compound_code = plusCode.compound_code;
        plusCode1.global_code = plusCode.global_code;

        return plusCode1;
    }

    protected List<PlaceInfoLocationDTO> placeInfoLocationSetToPlaceInfoLocationDTOList(Set<PlaceInfoLocation> set) {
        if ( set == null ) {
            return null;
        }

        List<PlaceInfoLocationDTO> list = new ArrayList<PlaceInfoLocationDTO>( set.size() );
        for ( PlaceInfoLocation placeInfoLocation : set ) {
            list.add( toPlaceInfoLocationDTO( placeInfoLocation ) );
        }

        return list;
    }

    protected PlaceInfoLocationDTO nearByLocationInfoDTOToPlaceInfoLocationDTO(NearByLocationInfoDTO nearByLocationInfoDTO) {
        if ( nearByLocationInfoDTO == null ) {
            return null;
        }

        PlaceInfoLocationDTO placeInfoLocationDTO = new PlaceInfoLocationDTO();

        placeInfoLocationDTO.id = nearByLocationInfoDTO.id;
        placeInfoLocationDTO.business_status = nearByLocationInfoDTO.business_status;
        placeInfoLocationDTO.geometry = nearByLocationInfoDTO.geometry;
        placeInfoLocationDTO.icon = nearByLocationInfoDTO.icon;
        placeInfoLocationDTO.icon_background_color = nearByLocationInfoDTO.icon_background_color;
        placeInfoLocationDTO.icon_mask_base_uri = nearByLocationInfoDTO.icon_mask_base_uri;
        placeInfoLocationDTO.name = nearByLocationInfoDTO.name;
        placeInfoLocationDTO.opening_hours = nearByLocationInfoDTO.opening_hours;
        ArrayList<org.ezgi.app.nearbylocation.search.dto.classes.Photo> arrayList = nearByLocationInfoDTO.photos;
        if ( arrayList != null ) {
            placeInfoLocationDTO.photos = new ArrayList<org.ezgi.app.nearbylocation.search.dto.classes.Photo>( arrayList );
        }
        placeInfoLocationDTO.place_id = nearByLocationInfoDTO.place_id;
        placeInfoLocationDTO.plus_code = nearByLocationInfoDTO.plus_code;
        placeInfoLocationDTO.price_level = nearByLocationInfoDTO.price_level;
        placeInfoLocationDTO.rating = nearByLocationInfoDTO.rating;
        placeInfoLocationDTO.reference = nearByLocationInfoDTO.reference;
        placeInfoLocationDTO.scope = nearByLocationInfoDTO.scope;
        ArrayList<String> arrayList1 = nearByLocationInfoDTO.types;
        if ( arrayList1 != null ) {
            placeInfoLocationDTO.types = new ArrayList<String>( arrayList1 );
        }
        placeInfoLocationDTO.user_ratings_total = nearByLocationInfoDTO.user_ratings_total;
        placeInfoLocationDTO.vicinity = nearByLocationInfoDTO.vicinity;

        return placeInfoLocationDTO;
    }

    protected List<PlaceInfoLocationDTO> nearByLocationInfoDTOArrayListToPlaceInfoLocationDTOList(ArrayList<NearByLocationInfoDTO> arrayList) {
        if ( arrayList == null ) {
            return null;
        }

        List<PlaceInfoLocationDTO> list = new ArrayList<PlaceInfoLocationDTO>( arrayList.size() );
        for ( NearByLocationInfoDTO nearByLocationInfoDTO : arrayList ) {
            list.add( nearByLocationInfoDTOToPlaceInfoLocationDTO( nearByLocationInfoDTO ) );
        }

        return list;
    }

    protected PlaceInfoLocation nearByLocationInfoDTOToPlaceInfoLocation(NearByLocationInfoDTO nearByLocationInfoDTO) {
        if ( nearByLocationInfoDTO == null ) {
            return null;
        }

        PlaceInfoLocation placeInfoLocation = new PlaceInfoLocation();

        placeInfoLocation.id = nearByLocationInfoDTO.id;
        placeInfoLocation.business_status = nearByLocationInfoDTO.business_status;
        placeInfoLocation.icon = nearByLocationInfoDTO.icon;
        placeInfoLocation.icon_background_color = nearByLocationInfoDTO.icon_background_color;
        placeInfoLocation.icon_mask_base_uri = nearByLocationInfoDTO.icon_mask_base_uri;
        placeInfoLocation.name = nearByLocationInfoDTO.name;
        placeInfoLocation.place_id = nearByLocationInfoDTO.place_id;
        placeInfoLocation.price_level = nearByLocationInfoDTO.price_level;
        placeInfoLocation.rating = nearByLocationInfoDTO.rating;
        placeInfoLocation.reference = nearByLocationInfoDTO.reference;
        placeInfoLocation.scope = nearByLocationInfoDTO.scope;
        ArrayList<String> arrayList = nearByLocationInfoDTO.types;
        if ( arrayList != null ) {
            placeInfoLocation.types = new ArrayList<String>( arrayList );
        }
        placeInfoLocation.user_ratings_total = nearByLocationInfoDTO.user_ratings_total;
        placeInfoLocation.vicinity = nearByLocationInfoDTO.vicinity;
        placeInfoLocation.geometry = geometryToGeometry( nearByLocationInfoDTO.geometry );
        placeInfoLocation.plus_code = plusCodeToPlusCode( nearByLocationInfoDTO.plus_code );
        placeInfoLocation.opening_hours = openingHoursToOpeningHours( nearByLocationInfoDTO.opening_hours );
        placeInfoLocation.photos = photoArrayListToPhotoArrayList( nearByLocationInfoDTO.photos );

        return placeInfoLocation;
    }
}
