package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig  {

	/**
	 * From Spring Security 5.7, the WebSecurityConfigurerAdapter is deprecated to encourage users
	 * to move towards a component-based security configuration. It is recommended to create a bean
	 * of type SecurityFilterChain for security related configurations.
	 * @param http
	 * @return SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

		/**
		 * Default configurations which will secure all the requests
		 * 表定全部都驗證
		 */
		/*((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().anyRequest()).
				authenticated();
		http.formLogin();
		http.httpBasic();
		return (SecurityFilterChain)http.build();*/

		/**
		 * Custom configurations as per our requirement
		 * 設定驗證依照路徑
		 */
		http.authorizeHttpRequests( (auth)->auth
				.antMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
				.antMatchers("/notices","/contact").permitAll()
		).httpBasic(Customizer.withDefaults());
		return http.build();

		/**
		 * Configuration to deny all the requests
		 * 拒絕所有連線
		 */
//		http.authorizeHttpRequests( (auth)->auth
//				.anyRequest().denyAll())
//				.httpBasic(Customizer.withDefaults());
//		return http.build();

		/**
		 * Configuration to permit all the requests
		 * 同意所有連線
		 */
//		http.authorizeHttpRequests( (auth)->auth
//						.anyRequest().permitAll())
//				.httpBasic(Customizer.withDefaults());
//		return http.build();
	}

}
