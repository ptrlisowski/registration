package pl.sda.nordea.registration.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity

public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery("select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from userroles where username=?");
	}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
//			http
//			.authorizeRequests()
//			.antMatchers("/", "/user/**")
//			.permitAll()
//			.antMatchers("/admin/**")
//			.hasRole("ADMIN")
//					.anyRequest()
//					.authenticated()
//					.and()
//					.formLogin()
//					.loginPage("/user/login")
//					.usernameParameter("username").passwordParameter("password")
//					.permitAll()
//					.successForwardUrl("/")
//					.loginProcessingUrl("/login")
//					.and()
//					.logout()
//					.permitAll();
//			http.exceptionHandling().accessDeniedPage("/403")
//			.and()
//			  .csrf();
			
			 http.authorizeRequests()
				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.and()
				  .formLogin().loginPage("/user/login")
				  .defaultSuccessUrl("/",true)
				  .failureUrl("/user/login?error")
				  .usernameParameter("username").passwordParameter("password")
				  
				.and()
				  .logout().logoutSuccessUrl("/")
				.and()
				  .exceptionHandling().accessDeniedPage("/403")
				.and()
				  .csrf();
		}
		
	}

