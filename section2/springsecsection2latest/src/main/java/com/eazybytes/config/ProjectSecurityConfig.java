package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig  {

	/**
	 *
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().anyRequest()).
				authenticated();
		http.formLogin();
		http.httpBasic();
		return (SecurityFilterChain)http.build();
	}

	/**
	 * /myAccount - Secured /myBalance - Secured /myLoans - Secured /myCards -
	 * Secured /notices - Not Secured /contact - Not Secured
	 *//*
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		*//**
		 * Default configurations which will secure all the requests
		 *//*

		*//*
		 * http .authorizeRequests() .anyRequest().authenticated() .and()
		 * .formLogin().and() .httpBasic();
		 *//*

		*//**
		 * Custom configurations as per our requirement
		 *//*

		*//*
		 * http .authorizeRequests() .antMatchers("/myAccount").authenticated()
		 * .antMatchers("/myBalance").authenticated()
		 * .antMatchers("/myLoans").authenticated()
		 * .antMatchers("/myCards").authenticated() .antMatchers("/notices").permitAll()
		 * .antMatchers("/contact").permitAll() .and() .formLogin().and() .httpBasic();
		 *//*

		*//**
		 * Configuration to deny all the requests
		 *//*

		*//*
		 * http .authorizeRequests() .anyRequest().denyAll() .and() .formLogin().and()
		 * .httpBasic();
		 *//*

		*//**
		 * Configuration to permit all the requests
		 *//*

		http .authorizeRequests() .anyRequest().permitAll().and() .formLogin().and()
		 .httpBasic();
		

	}*/

}
