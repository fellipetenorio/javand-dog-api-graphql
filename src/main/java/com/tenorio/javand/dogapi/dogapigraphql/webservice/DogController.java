package com.tenorio.javand.dogapi.dogapigraphql.webservice;

import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import com.tenorio.javand.dogapi.dogapigraphql.entity.Joke;
import com.tenorio.javand.dogapi.dogapigraphql.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is error 400"),
        @ApiResponse(code = 401, message = "This is error 401"),
        @ApiResponse(code = 500, message = "This is error 500")
})
public class DogController {
    private DogService dogService;
    private RestTemplate restTemplate;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs2")
    public List<Dog> findAllDogs() {
        return dogService.findAllDogs();
    }

    @GetMapping("/myapi")
    public Joke getApi() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);

        this.restTemplate = new RestTemplate(factory);

        String url = "https://official-joke-api.appspot.com/random_joke";
        return this.restTemplate.getForObject(url, Joke.class);
    }
}
