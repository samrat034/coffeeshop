package edu.mum.coffee.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Person;

@Repository
public class UserDetailServiceDAO implements UserDetailsService{
	
//	@Autowired
//	PersonService personService;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		//System.out.println("********Username Is::: "+arg0);
		
		Person person = new PersonDAO().findByEmail(arg0);
//		System.out.println("First Name:: "+person.getFirstName());
//		System.out.println("Last Name:: "+person.getLastName());
//		System.out.println("Email:: "+person.getEmail());
//		System.out.println("Password:: "+person.getPassword());
		
		UserDetails user = new UserDetailsImpl(arg0);
		
		return user;
	}

}
