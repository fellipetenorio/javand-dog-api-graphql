package com.tenorio.javand.dogapi.dogapigraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import com.tenorio.javand.dogapi.dogapigraphql.exception.DogNotFoundException;
import com.tenorio.javand.dogapi.dogapigraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog findDogById(Long id) {
        Optional<Dog> byId = dogRepository.findById(id);
        if(byId.isPresent())
            return byId.get();

        throw new DogNotFoundException("Dog not found", id);
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }
}
