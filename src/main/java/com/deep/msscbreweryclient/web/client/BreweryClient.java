package com.deep.msscbreweryclient.web.client;

import com.deep.msscbreweryclient.web.model.BeerDto;
import com.deep.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1="/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    //application.properties will map as sfg.brewery.apiHost for @ConfigurationProperties
    private String apiHost;//Decleare final in case of fail

    private RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+uuid.toString(),BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return  restTemplate.postForLocation(apiHost + BEER_PATH_V1,beerDto);
    }

    public void  updateBeer(UUID uuid,BeerDto beerDto){
        restTemplate.put(apiHost + BEER_PATH_V1 + UUID.randomUUID().toString(), beerDto);
    }

    public void  deleteBeer(UUID uuid){
        restTemplate.delete(apiHost + BEER_PATH_V1 + UUID.randomUUID().toString());
    }

    public void setApiHost(String apiHost) {

        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return restTemplate.getForObject(apiHost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return  restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomer(UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
    }
}
