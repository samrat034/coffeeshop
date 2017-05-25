package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.mum.coffee.service.UserDetailServiceDAO;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Below commented lines are runnable
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
//				.antMatchers("/dashboard").hasRole("USER").and().formLogin().defaultSuccessUrl("/dashboard")
//				.loginPage("/login").and().logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/").permitAll();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/*.css");
//		web.ignoring().antMatchers("/*.js");
//	}
	
	// Implementing Role Based URL Redirection and Authentication
	
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and().authorizeRequests()
				.antMatchers("/user/**").hasRole("USER")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.and().formLogin().successHandler(successHandler)
				.loginPage("/login").usernameParameter("username")
				.passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
//		String usernameQuery="select email, password, enable from person where email=?";
//		String roleQuery="select p.email, p.role from person p where p.email=?";
		
//		auth.jdbcAuthentication().usersByUsernameQuery(usernameQuery).authoritiesByUsernameQuery(roleQuery);
//		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
		
		auth.userDetailsService(new UserDetailServiceDAO());
	}
}