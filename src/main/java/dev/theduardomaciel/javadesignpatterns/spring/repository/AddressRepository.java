package dev.theduardomaciel.javadesignpatterns.spring.repository;

import dev.theduardomaciel.javadesignpatterns.spring.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}