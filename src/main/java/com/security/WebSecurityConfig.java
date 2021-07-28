package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.service.serviceImpl.StaffServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new StaffServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http    
                // .csrf().disable()
                // .authorizeRequests()
                // .antMatchers("/signup","/", "/login").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                // .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                // // .authorizeRequests()
                // // .and()
                // // .exceptionHandling()
                // // .accessDeniedPage("/404")
                // .and()
                // .formLogin() // Cho phép người dùng xác thực bằng form login
                //     .loginPage("/login")
                //     .defaultSuccessUrl("/home",true)
                //     .usernameParameter("username")
                //     .passwordParameter("password")
                // .and()
                // .logout() // Cho phép logout
                //     .logoutUrl("/logout");
    }
 
    
}