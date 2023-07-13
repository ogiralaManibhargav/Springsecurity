package com.patient.details.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.patient.details.security.jwt.AuthEntryPointJwt;
import com.patient.details.security.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig{
	  @Autowired
	  UserDetailsServiceImpl userDetailsService;

	  @Autowired
	  private AuthEntryPointJwt unauthorizedHandler;

	  @Bean
	  public AuthTokenFilter authenticationJwtTokenFilter() {
	    return new AuthTokenFilter();
	  }

	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userDetailsService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	  
	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	
		  @Bean
		  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		    http.csrf(csrf -> csrf.disable())
		        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
		        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		        .authorizeHttpRequests(auth ->
		      auth .requestMatchers("/openapi/**","/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
		        .requestMatchers("/api/auth/**").permitAll()
		        .requestMatchers("/api/test/**").permitAll()
		        
		        .anyRequest().authenticated()
		        //auth.requestMatchers("/**").permitAll()
		);
		    

	    

	    http.authenticationProvider(authenticationProvider());

	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	  }
		 /*
	  
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .cors().configurationSource(corsConfigurationSource())
	            .and()
	            .authorizeRequests()
	                .requestMatchers(swaggerUrls()).permitAll() // Allow access to Swagger UI endpoints
	                .requestMatchers("/api/auth/**").permitAll()
	                .requestMatchers("/api/test/**").permitAll()
	                .anyRequest().authenticated()
	            .and()
	            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler())
	            .and()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        http.authenticationProvider(authenticationProvider());
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

	        return http.build();
	    }

	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.addAllowedOrigin("*");
	        configuration.addAllowedMethod("*");
	        configuration.addAllowedHeader("*");
	        configuration.setAllowCredentials(true);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);

	        return source;
	    }

	    private RequestMatcher swaggerUrls() {
	        return new OrRequestMatcher(
	            new AntPathRequestMatcher("/swagger-ui.html"),
	            new AntPathRequestMatcher("/swagger-ui/**"),
	            new AntPathRequestMatcher("/v3/api-docs/**"),
	            new AntPathRequestMatcher("/openapi/**")
	        );
	    }

	    @Bean
	    public AuthenticationEntryPoint unauthorizedHandler() {
	        return new AuthEntryPointJwt();
	    }
*/
		
	  


}
