package org.talentboost.networkforgiving.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.talentboost.networkforgiving.model.Charity;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharityControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetCharity() {
        ResponseEntity responseEntity = restTemplate.getForEntity("/charity/1", Charity.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.OK, responseStatus);
    }

    @Test
    void testGetAll() {
        ResponseEntity<List<Charity>> responseEntity = restTemplate.exchange("/charity",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Charity>>() {});
        HttpStatus responseStatus = responseEntity.getStatusCode();

        final List<Charity> charityList = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseStatus);
        assertNotNull(charityList);
        assertFalse(charityList.isEmpty());
    }

    @Test
    void testAddCharity() {
        Charity charity = new Charity(1, "TestCharity", "null", "TestDescription",
                10, 100, 1);
        ResponseEntity responseEntity = restTemplate.postForEntity("/charity", charity, Void.class);
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.OK, responseStatus);

    }

    @Test
    void updateCharity() {
        Charity charity = new Charity(1, "TestCharity", "null", "TestDescription",
                10, 100, 1);
        HttpHeaders headers = restTemplate.headForHeaders("/charity");
        HttpEntity<Charity> requestUpdate = new HttpEntity<>(charity, new HttpHeaders());
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/charity/1", HttpMethod.PUT, requestUpdate, Void.class );
        HttpStatus responseStatus = responseEntity.getStatusCode();

    }

    @Test
    void testDeleteCharity() {
        ResponseEntity responseEntity = restTemplate.exchange("/charity/1",
                HttpMethod.DELETE, null, Void.class );
        HttpStatus responseStatus = responseEntity.getStatusCode();
        assertEquals(HttpStatus.UNAUTHORIZED, responseStatus);
    }
}