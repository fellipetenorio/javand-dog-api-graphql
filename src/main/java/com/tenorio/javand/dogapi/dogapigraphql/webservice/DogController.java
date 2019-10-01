package com.tenorio.javand.dogapi.dogapigraphql.webservice;

import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import com.tenorio.javand.dogapi.dogapigraphql.entity.Joke;
import com.tenorio.javand.dogapi.dogapigraphql.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class DogController {
    private DogService dogService;
    private RestTemplate restTemplate;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @RequestMapping("/dogs2")
    public Iterable<Dog> findAllDogs() {
        return dogService.findAllDogs();
    }

    @RequestMapping("/myapi")
    public Joke getApi(RestTemplate restTemplate) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);

        this.restTemplate = new RestTemplate(factory);

        String url = "https://official-joke-api.appspot.com/random_joke";
        return this.restTemplate.getForObject(url, Joke.class);
    }
}
