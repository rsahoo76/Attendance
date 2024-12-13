

/* 2/8 */
package com.cg.university.Attendance.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(List.of("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }))
                .csrf(csrfConfig -> csrfConfig.disable())
//                cors(Customizer.withDefaults()).
//                authorizeHttpRequests(r -> r.anyRequest().authenticated())
//                here inside authorizehttp.. it is lambda expression
                .authorizeHttpRequests(r -> {
//            r.anyRequest().authenticated("/home");})
//            r.requestMatchers("/test").permitAll();
                    r.requestMatchers("/admin/**").hasRole("admin");
                    r.requestMatchers("/teacher/**").hasRole("teacher");
                    r.requestMatchers("/student/**").hasRole("student");
                    r.anyRequest().authenticated();
                })

//                   r.requestMatchers("/Calendarevents").authenticated();})
//                .formLogin(Customizer.withDefaults())
//                .formLogin(flc->flc.loginPage("/login"))
                .httpBasic(Customizer.withDefaults())
//                .formLogin(flc->flc.loginPage("/login"))  This will be given from our customize page
//                .formLogin(flc->flc.disable())    This will disable the login page
//                .httpBasic(hbc->hbc.disable())  // to disable basic authentication

                .build();
    }

//    @Bean
//    public InMemoryUserDetailsManager authenticationManager() {
//    IF you do not use any password encoder then this will throw an error to resolve this you need to use noop
//Like this UserDetails user = User.withUsername("test").password("{noop}12345").authorities("user").build();
//        UserDetails user = User.withUsername("test").password("password").authorities("user").build();
//        UserDetails admin = User.withUsername("admin").password("admin@23").authorities("admin").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

//    @Bean UserDetailsService UserDetailsService(){
//        return new UserServiceImpl();
//    }

}













/*
@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
//        return http
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
//                .build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        return http.csrf(http::disable)
//                .authorizeHttpRequests(auth ->
//                        auth.requestMatchers("/login").permitAll()
//                                .requestMatchers("/login/**")
//                                .authenticated()
//                                .and()
//                                .formLogin()
////                                .loginPage("/login")
////                                .defaultSuccessUrl("/home", true)
////                                .failureUrl("/login?error=true")
//
//                )
//                .httpBasic(Customizer.withDefaults())
//                .build();
        return http.authorizeHttpRequests(r -> r.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    //This is using database authenticating the user
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }


//    @Bean
//    public InMemoryUserDetailsManager authenticationManager() {
//        UserDetails u = User.withUsername("test").password("password").authorities("user").build();
//
//        return new InMemoryUserDetailsManager(u);
//    }

//    @Bean
//    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
//        return http
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
//                .build();
//    }

}



*/


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}





/*

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/users").hasRole("ADMIN")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}

 */