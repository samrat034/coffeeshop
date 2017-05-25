package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value="/admin/addPerson", method=RequestMethod.GET)
	public String loadAddPerson( Model model){
		model.addAttribute("person", new Person());
		return "addPerson";
	}
	
	
	@RequestMapping(value="/admin/addPerson", method=RequestMethod.POST)
	public String savePerson(@ModelAttribute Person person, Model model){
		personService.savePerson(person);
		return "redirect:/admin/listPerson";
	}
	
	@RequestMapping(value="/admin/listPerson", method=RequestMethod.GET)
	public String listPerson(Model model){
		List<Person> personList = personService.findAll();
		model.addAttribute("persons",personList);
		return "personList";
	}
	
	@RequestMapping(value="/deletePerson/{id}", method=RequestMethod.GET)
	public String deletePerson(@PathVariable("id") long id){
		personService.removePerson(personService.findById(id));
		return "redirect:/admin/listPerson";
	}
	
	@RequestMapping(value="/updatePerson/{id}", method=RequestMethod.GET)
	public String loadUpdatePerson(@PathVariable("id") long id, Model model){
		model.addAttribute("person", personService.findById(id));
		return "addPerson";
	}
	
	@RequestMapping(value = "/updatePerson/{id}", method = RequestMethod.POST)
	public String saveEditedUser(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, 
			@RequestParam(value="id") long id, @ModelAttribute("person") Person person) {
		if (cancel != null) {
			return "redirect:/admin/listPerson";
		} else {
			personService.updatePerson(person, id);
		}
		return "redirect:/admin/listPerson";
	}
	
}
