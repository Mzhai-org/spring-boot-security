
package com.zs.springbootsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
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
//    http.authorizeRequests()
//        .anyRequest().authenticated() //任何请求,登录后可以访问
//        .and()
//        .formLogin()
//        .loginPage("/login")
//        .failureUrl("/login?error")
//        .permitAll() //登录页面用户任意访问
//        .and()
//        .logout().permitAll(); //注销行为任意访问

    http
        .csrf().disable()
        .anonymous().disable()
        .authorizeRequests()
        .antMatchers("/admin","/oauth/token").permitAll()
        .anyRequest().authenticated();


  }

//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    //解决静态资源被拦截的问题
//    web.ignoring().antMatchers("/css/**");
//  }
  
}
