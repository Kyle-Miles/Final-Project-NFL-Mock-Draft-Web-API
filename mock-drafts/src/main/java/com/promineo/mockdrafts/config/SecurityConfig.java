package com.promineo.mockdrafts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.promineo.mockdrafts.config.user.SecurityUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration{

	@Autowired
	SecurityUserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf
				.ignoringAntMatchers(
						"/nfldraft/player/**"
						, "/nfldraft/team/**"
						, "/nfldraft/mock_draft/**"
						, "/nfldraft/team_needs/**"
						, "/nfldraft/user/**"))
				.cors()
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET
						, "/nfldraft/user")
				.hasAuthority("ROLE_ADMIN")
				.antMatchers(HttpMethod.GET
						, "/nfldraft/**")
				.hasAuthority("ROLE_USER")
				.antMatchers(HttpMethod.POST
						, "/nfldraft/player/**"
						, "/nfldraft/mock_draft/**"
						, "/nfldraft/user/**")
				.hasAuthority("ROLE_ADMIN")
				.antMatchers(HttpMethod.PUT
						, "/nfldraft/player/**"
						, "/nfldraft/team/**"
						, "/nfldraft/mock_draft/**"
						, "/nfldraft/team_needs/**")
				.hasAuthority("ROLE_ADMIN")
				.antMatchers(HttpMethod.DELETE
						, "/nfldraft/player/**"
						, "/nfldraft/mock_draft/**")
				.hasAuthority("ROLE_ADMIN")
				.and()
				.formLogin(Customizer.withDefaults())
				.build();
	}


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(); 
	}
}
