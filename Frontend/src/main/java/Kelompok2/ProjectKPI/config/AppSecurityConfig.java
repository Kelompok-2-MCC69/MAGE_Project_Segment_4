package Kelompok2.ProjectKPI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/login/**").permitAll()
        .antMatchers("/css/**","/js/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login") 
        .loginProcessingUrl("/login") 
        .successForwardUrl("/employee") 
        .failureForwardUrl("/login?error=true") 
        .permitAll()
        .and()
        .logout()
        .logoutUrl("/logout").permitAll();
        
    }
    
}
