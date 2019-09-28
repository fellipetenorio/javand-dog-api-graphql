package com.tenorio.javand.dogapi.dogapigraphql.service;

import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import com.tenorio.javand.dogapi.dogapigraphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> findAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }
}
