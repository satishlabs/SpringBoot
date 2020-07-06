package com.satish;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.satish")
public class MvcConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{
	@Autowired
	private DataSource dataSource;

	@Bean 
	public InternalResourceViewResolver viewResolver() { 
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setPrefix("/WEB-INF/views/"); 
		resolver.setSuffix(".jsp"); 
		resolver.setViewClass(JstlView.class); 
		return resolver; 
	} 

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Autowired
	public void configureGloabal(AuthenticationManagerBuilder auth) throws Exception {
		String usersQuery="select username,password, active from myusers where username=?"; 
		String rolesQuery="select username, role from myroles where username=?"; 

		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(usersQuery)
		.authoritiesByUsernameQuery(rolesQuery);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/deleteBook**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/addBook**").access("hasAnyRole('ROLE_ADMIN','ROLE_STOREKEEPER')")
		.antMatchers("/editBook**").access("hasAnyRole('ROLE_ADMIN','ROLE_STOREKEPPER')")
		.antMatchers("/placeOrder**").access("hasAnyRole('ROLE_CUSTOMER')")
		.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login?error")
		.usernameParameter("myusername").passwordParameter("mypassword")
		.and()
		.logout().invalidateHttpSession(true)
		.logoutSuccessUrl("/login?logout")
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/invalidAccess.jsp")
		.and().csrf().and()
		.sessionManagement()
		.enableSessionUrlRewriting(true)
		.maximumSessions(1);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
}
