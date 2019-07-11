package com.mlaxn.demoSpringDataJPA;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Crude Repository is the interface that implements the DAO parts such as create, read, update and delete
 * It takes the model class and the id of the type integer
 **/
@Repository
public interface DogsRepository extends CrudRepository<Dog, Long> {}