package com.SW2.secConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.SW2.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;
	@Bean
    public UserDetailsService jpaUserDetails() {
        return new UserDetailsServiceImpl();
    }
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	UserDetailsService userDetailsService = jpaUserDetails();
	    	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {  
		  http.authorizeRequests().antMatchers("/all").hasAuthority("ADMIN").antMatchers("/addAdmin").hasAuthority("ADMIN")
          .antMatchers("/addUser").permitAll().antMatchers("/addSeller").permitAll().anyRequest().authenticated().and().formLogin().successHandler(customizeAuthenticationSuccessHandler)
          .failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password").and().logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
          .exceptionHandling();
	}
}