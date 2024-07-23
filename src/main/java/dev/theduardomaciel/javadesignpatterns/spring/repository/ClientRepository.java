package dev.theduardomaciel.javadesignpatterns.spring.repository;

import dev.theduardomaciel.javadesignpatterns.spring.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// O Spring Data JPA fornece uma interface CrudRepository, que seria equivalente uma Strategy Pattern

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}