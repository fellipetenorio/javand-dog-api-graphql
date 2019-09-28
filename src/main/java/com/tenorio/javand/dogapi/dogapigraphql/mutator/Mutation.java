package com.tenorio.javand.dogapi.dogapigraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import com.tenorio.javand.dogapi.dogapigraphql.exception.DogNotFoundException;
import com.tenorio.javand.dogapi.dogapigraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(Long id) {
        dogRepository.deleteById(id);
        return true;
    }

    public Dog updateDogName(Long id, String newName) {
        Optional<Dog> byId = dogRepository.findById(id);

        if(!byId.isPresent()) {
            throw new DogNotFoundException("Dog not found", id);
        }

        Dog dog = byId.get();
        dog.setName(newName);
        dogRepository.save(dog);

        return dog;
    }
}
