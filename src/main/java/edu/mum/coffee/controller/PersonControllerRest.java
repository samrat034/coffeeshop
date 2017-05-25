package edu.mum.coffee.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonControllerRest {
	
	final static Logger logger = Logger.getLogger(ProductControllerRest.class);
	
	@Autowired
	PersonService personService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllPerson() {
		List<Person> person = personService.findAll();
		if (person.isEmpty()) {
			logger.debug("Person does not exists");
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		personService.savePerson(person);
		logger.debug("Added:: " + person);
		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPerson(@PathVariable("id") long id) {
		Person person = personService.findById(id);
		if (person == null) {
			logger.debug("Person with id " + id + " does not exists");
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Person:: " + person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	
	

}
