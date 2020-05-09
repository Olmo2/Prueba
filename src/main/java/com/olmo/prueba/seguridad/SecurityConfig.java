package com.olmo.prueba.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.olmo.prueba.servicios.Autenticacion;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {


    @Autowired
    private Autenticacion autenticacion;

    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(autenticacion);
    	
    	auth.authenticationProvider(provider);
    }   



    
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        	.antMatchers("/juegos").permitAll()
        	.antMatchers("/juegos/{plataforma}").permitAll()
        	.antMatchers("/juegos/**").hasAuthority("ADMIN")
        	.antMatchers("/plataformas").permitAll()
        	.antMatchers("/plataforma/**").hasAuthority("ADMIN")
        	.and()
        .formLogin()
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/juegos")
            .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/juegos")
        	.permitAll()
            .and()
        .csrf().disable();

    }

}