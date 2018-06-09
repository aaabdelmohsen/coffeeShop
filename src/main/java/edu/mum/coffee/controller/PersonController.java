package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person/")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    Response response;

    @PostMapping("create")
    public Response createPerson(@RequestBody Person person) {
        Person personRes = personService.savePerson(person);
        if (personRes != null) {
            response.setErrorCode(200);
            response.setMessage("Success, Person was added with ID: " + personRes.getId());
        } else {
            response.setErrorCode(400);
            response.setMessage("The request did not execute as expected.");
        }
        return response;
    }

    @PutMapping("update")
    public Response updatePerson(@RequestBody Person person) {
        Person personRes = personService.savePerson(person);
        if (personRes != null) {
            response.setErrorCode(200);
            response.setMessage("Success, Person was Updated with ID: " + person.getId());
        } else {
            response.setErrorCode(400);
            response.setMessage("The request did not execute as expected.");
        }
        return response;
    }

    @GetMapping("list")
    public List<Person> listAllPersons() {
        return personService.getAllPerson();
    }

    @GetMapping("getPersonById/{personId}")
    public Person getPersonById(@PathVariable Long personId) {
        return personService.findById(personId);
    }
}
