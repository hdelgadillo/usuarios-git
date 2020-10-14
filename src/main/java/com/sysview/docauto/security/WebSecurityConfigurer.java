package com.sysview.docauto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	 OracleDataSource dataSource;
	 @Autowired
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication()
	            .dataSource(dataSource)
	            .usersByUsernameQuery(
	              "select USUARIOPROPIO, USUARIOPROPIOPASSWORD, 1 as ACTIVO from USUARIOPROPIO where USUARIOPROPIO=?")
	            .authoritiesByUsernameQuery(
	                "select USUARIOPROPIO, ROL from USUARIOPROPIO where USUARIOPROPIO = ?"
	        );
	 }
	 @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/up/**"); // #3
	  }
	 
	 @Override
     protected void configure(HttpSecurity http) throws Exception {
		 http
		 .csrf().disable()
		 		//Mostrar imagenes sin tener que estar logueado
            .authorizeRequests().antMatchers("/Img/**").permitAll()
            .antMatchers("/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
          .and()
        .formLogin()
            .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll().and().exceptionHandling().accessDeniedPage("/403"); 
      
    }
}


//ORIGINAL
 
 /*@Autowired
	OracleDataSource dataSource;
	 @Autowired
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication()
	            .dataSource(dataSource)
	            .usersByUsernameQuery(
	              "select USUARIOPROPIO, USUARIOPROPIOPASSWORD, 1 as ACTIVO from USUARIOPROPIO where USUARIOPROPIO=?")
	            .authoritiesByUsernameQuery(
	                "select USUARIOPROPIO, ROL from USUARIOPROPIO where USUARIOPROPIO = ?"
	        );
	 }
   
	 @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/up/**"); // #3
	  }
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
        	.csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()
          .and()
        .formLogin()
            .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll(); 
      
    }*/

//Forma para delimitar si puede acceder o no a url si no es admin
/*
   @Override
    protected void configure(HttpSecurity http) throws Exception {
          http
        	.csrf().disable()
            .authorizeRequests()
            .antMatchers("/menusr/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
          .and()
        .formLogin()
            .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll(); 
      
    }*/
