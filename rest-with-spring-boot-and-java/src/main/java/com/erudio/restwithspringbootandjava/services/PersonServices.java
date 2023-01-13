package com.erudio.restwithspringbootandjava.services;

import com.erudio.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import com.erudio.restwithspringbootandjava.model.Person;
import com.erudio.restwithspringbootandjava.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {

        logger.info("Find all people!");

        return personRepository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding one person!");

        return personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {

        logger.info("Create one person!");

        return personRepository.save(person);
    }

    public Person update(Person person) {

        logger.info("Update one person!");

        Person personUpdated = personRepository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));

        personUpdated.setFirstName(person.getFirstName());
        personUpdated.setLastName(person.getLastName());
        personUpdated.setAddress(person.getAddress());
        personUpdated.setGender(person.getGender());

        return personRepository.save(personUpdated);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        Person person = personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));

        personRepository.delete(person);

    }

}
