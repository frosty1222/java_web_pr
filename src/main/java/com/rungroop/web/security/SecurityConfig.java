package com.rungroop.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private UserDetailsService userDetailService;
    @Autowired
    public SecurityConfig(CustomUserDetailService customUserDetailService) {
        this.userDetailService = customUserDetailService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeRequests()
                .requestMatchers("/login", "/register", "/clubs", "/css/**", "/js/**", "/customCss/**", "/customJs/**") // Fix missing "**" for URL patterns
                .permitAll()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/clubs?login")
                        .loginProcessingUrl("/login") // This line is unnecessary, as Spring Security handles it by default
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Fix capitalization of "AntPathRequestMatcher"
                        .logoutSuccessUrl("/login") // Add a logout success URL
                        .permitAll()
                );
        return http.build();
    }
    public void configure(AuthenticationManagerBuilder builder) throws Exception{
      builder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
}
