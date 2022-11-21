package com.Employee.config;

import com.Employee.service.CustomeTeacherService;
import com.Employee.service.CustomeuserDetailsService;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class webConfigFile extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService teacherDetailsService(){
        return new CustomeTeacherService();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomeuserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    public DaoAuthenticationProvider authenticationProvider1(){
        DaoAuthenticationProvider authProvider =new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(teacherDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.authenticationProvider(authenticationProvider());
      auth.authenticationProvider(authenticationProvider1());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/register").hasRole("ADMIN")
                .antMatchers("/updateTeacher").hasRole("ADMIN")
                .antMatchers("/updateStudent").hasRole("ADMIN")
                .antMatchers("/teacher").hasRole("ADMIN")
                .antMatchers("/homepage")
                .authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/valide")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/homepage")
                .usernameParameter("email")


                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/LogOut"))
                .logoutSuccessUrl("/homepage")
                .invalidateHttpSession(true)        // set invalidation state when logout
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/denied");
    }


}
