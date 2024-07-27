package org.ezgi.app.nearbylocation.search;

import org.ezgi.app.nearbylocation.search.dto.NearByLocationDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;



@Disabled
class NearByLocationInfoSearchTest{
    private final RestTemplate m_restTemplate = new RestTemplate();
    private final String m_locationUrl = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?keyword=cruise&location=%f,%f&radius=1500&type=restaurant&key=xxxxx", -33.8670522, 151.1957362);


    @Test
    void testLocationElevation() {
        var nbl = m_restTemplate.getForObject(m_locationUrl, NearByLocationDTO.class);
        var expectedStatus = "OK";

        Assertions.assertNotNull(nbl);
        Assertions.assertEquals(expectedStatus, nbl.status);
    }


}
