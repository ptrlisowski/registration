package pl.sda.nordea.registration.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from userroles where username=?");

	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
		return manager;
}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
        http
        .authorizeRequests()  
        .antMatchers("/", "/user/**").permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/visit/**").hasRole("USER")
        .anyRequest().authenticated()
        .and()
		 .formLogin()
		 .loginPage("/user/login")
		 .usernameParameter("username").passwordParameter("password")
        .permitAll()
        .defaultSuccessUrl("/", true)
        .failureUrl("/user/")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/user/")
        .invalidateHttpSession(true);
	}
	
	
	
	
}
