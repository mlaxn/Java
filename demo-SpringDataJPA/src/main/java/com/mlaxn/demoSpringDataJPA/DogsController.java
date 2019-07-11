package com.mlaxn.demoSpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * Controller Class that controlls each end-rest points to the designated method call
 * Problem: it shows that the Controller method is never used, also the controller methods ????
 */

@RestController
@RequestMapping("/dogs")
public class DogsController {
    @Autowired DogsService dogsService;

    @GetMapping("/getAll")
    public List<Dog> getDogs() {
        return dogsService.getDogs();
    }

    @PostMapping("/add/{name}/{age}")
    public void postDogs(@RequestBody DogDto dto) {
        dogsService.add(dto);
    }

    @GetMapping("get/{id}")
    public Dog getById(@PathVariable(required = true) long id) {
        return dogsService.getDogById(id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(required = true) long id) {
        dogsService.delete(id);
    }
}