package com.tenorio.javand.dogapi.dogapigraphql.webservice;

import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import com.tenorio.javand.dogapi.dogapigraphql.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @RequestMapping("/dogs")
    public Iterable<Dog> findAllDogs() {
        return dogService.findAllDogs();
    }
}
