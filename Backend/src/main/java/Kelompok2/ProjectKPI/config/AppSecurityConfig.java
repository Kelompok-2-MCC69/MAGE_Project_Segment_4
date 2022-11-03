package Kelompok2.ProjectKPI.config;

import Kelompok2.ProjectKPI.service.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserDetailService appUserDetailService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(AppUserDetailService appUserDetailService, PasswordEncoder passwordEncoder) {
        this.appUserDetailService = appUserDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(appUserDetailService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/kpi/mykpi/**").hasAnyRole("EMPLOYEE")
                    .antMatchers("/kpi/**").hasRole("EMPLOYEE")
                    .antMatchers("/employee/**").hasRole("MANAGER")
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic();

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
