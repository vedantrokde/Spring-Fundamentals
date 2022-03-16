package com.code.springsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // DataSource created by JPA H2 is auto wired directly
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/home").hasRole("EMPLOYEE")
            .antMatchers("/leaders/**").hasRole("MANAGER")
            .antMatchers("/systems/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .permitAll()
            .and()
                .logout()
                .permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);

        /*
        // add users for in-memory authentication
        @SuppressWarnings("deprecation" )
        UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("test1").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("test2").password("test123").roles("EMPLOYEE", "MANAGER"))
                .withUser(users.username("admin").password("test123").roles("EMPLOYEE", "ADMIN"));
        */
    }
}
