//package com.ExamportalSpringboot.Security;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class Security extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("vinod")
//		.password("vinod@123")
//		.roles("Admin")
//		.and()
//		.withUser("vinod")
//		.password("vinod@123")
//		.roles("Student");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/**").hasRole("Admin")
//		.antMatchers("/questionbyexamid/{id}").hasRole("Student")
//		.antMatchers("/submitanswer").hasRole("Student")
//		.antMatchers("/GetReportById/{id}").hasRole("Student")
//		.antMatchers("/GetStudentById/{id}").hasRole("Student");
//		
//	}
//}
