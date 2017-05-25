package edu.mum.coffee.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

public class UserDetailsImpl implements UserDetails{
	
	private String userEmail;
	private Person person;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7365736441447948062L;
	
	public UserDetailsImpl(String username){
		this.userEmail = username;
		this.person = new PersonDAO().findByEmail(userEmail);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
		auths.add(new SimpleGrantedAuthority("ROLE_"+person.getRole()));
		return auths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return person.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
