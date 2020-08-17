package com.deep.msscbreweryclient.web.client;

import com.deep.msscbreweryclient.web.model.BeerDto;
import com.deep.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//Integration TEST
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto=client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewUser() {
       BeerDto beerDto = BeerDto.builder().beerName("king").build();
       URI uri = client.saveNewBeer(beerDto);
       assertNotNull(uri);
       System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        BeerDto beerDto=BeerDto.builder().beerName("k8").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto=client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto=CustomerDto.builder().name("deep").build();
        URI uri=client.saveNewCustomer(customerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerDto=CustomerDto.builder().name("Deep").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}