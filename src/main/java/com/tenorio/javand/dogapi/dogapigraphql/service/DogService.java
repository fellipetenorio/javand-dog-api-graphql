package com.tenorio.javand.dogapi.dogapigraphql.service;

import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> findAllDogs();
}
