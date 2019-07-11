package com.mlaxn.demoSpringDataJPA;

import com.mlaxn.demoSpringDataJPA.Dog;
import com.mlaxn.demoSpringDataJPA.DogDto;
import org.springframework.stereotype.Component;
import com.mlaxn.demoSpringDataJPA.DogsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * It is the service class that takes the DogsRepository using the Autowiring
 * Autowired creates the bean for each functions that are necessary
 */
@Service
public class DogsService {
    @Autowired DogsRepository dogRepository;

    public void add(DogDto dto) {
        dogRepository.save(toEntity(dto));
    }

    public void delete(long id) {
        dogRepository.deleteById(id);
    }

    public List<Dog> getDogs() { return (List<Dog>) dogRepository.findAll(); }

    public Dog getDogById(long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        return optionalDog.orElseThrow(() -> new DogNotFoundException("Couldn't find a Dog with id: " + id));
    }

    private Dog toEntity(DogDto dto) {
        Dog entity = new Dog();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        return entity;
    }
}