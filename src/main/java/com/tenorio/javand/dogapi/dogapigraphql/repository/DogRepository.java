package com.tenorio.javand.dogapi.dogapigraphql.repository;

import com.tenorio.javand.dogapi.dogapigraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
