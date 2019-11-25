
package com.zs.springbootsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: WebSecurityConfig.java, v1.0 2019/11/20 18:07 zhaishuo Exp $
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  UserDetailsService customUserService(){ //注册UserDetailsService 的bean
    return new CustomUserService();
  }
  
  @Autowired
  OAuth2AuthenticationProvider authenticationProvider;

//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(customUserService()).passwordEncoder(passwordEncoder()); //user Details Service验证
    
    auth.authenticationProvider(authenticationProvider);
  }

  /**
   * Register authenticationManager
   *
   * @return
   * @throws Exception
   */
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .anonymous().disable()
        .authorizeRequests()
        .antMatchers("/admin","/oauth/token").permitAll()
        .anyRequest().authenticated();

  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    //解决静态资源被拦截的问题
    web.ignoring().antMatchers("/css/**");
  }
  
}
