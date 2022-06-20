package com.master.covidservice.covidservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public WebSecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/api/v1/application")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/api/v1/article", "/api/v1/article/{id}", "/api/v1/institution")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/api/v1/statistic")
                .permitAll()

                .antMatchers(HttpMethod.POST, "/api/v1/institution")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/api/v1/application", "/api/v1/application/{id}")
                .hasAnyAuthority("Institution", "Admin")
                .antMatchers(HttpMethod.PUT, "/api/v1/application/{id}")
                .hasAnyAuthority("Institution", "Admin")
                .antMatchers(HttpMethod.DELETE, "/api/v1/application/{id}")
                .hasAnyAuthority("Institution", "Admin")

                .antMatchers(HttpMethod.POST, "/api/v1/article")
                .hasAuthority("Covid Rules Provider")
                .antMatchers(HttpMethod.PUT, "/api/v1/article/{id}")
                .hasAuthority("Covid Rules Provider")
                .antMatchers(HttpMethod.DELETE, "/api/v1/article/{id}")
                .hasAuthority("Covid Rules Provider")

                .antMatchers(HttpMethod.GET, "/api/v1/statistic")
                .hasAuthority("Covid Statistic Provider")

                .antMatchers(HttpMethod.PUT, "/api/v1/institution/{id}")
                .hasAnyAuthority("Admin", "Institution")
                .antMatchers(HttpMethod.DELETE, "/api/v1/institution/{id}")
                .hasAnyAuthority("Admin")


                .anyRequest()
                .denyAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
