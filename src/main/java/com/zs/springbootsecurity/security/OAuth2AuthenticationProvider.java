
package com.zs.springbootsecurity.security;

import com.zs.springbootsecurity.bo.User;
import com.zs.springbootsecurity.security.passwordencoder.MyPasswordEncoder;
import com.zs.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: MyAuthenticationProvider.java, v1.0 2019/11/25 10:33 zhaishuo Exp $
 */
@Component
public class OAuth2AuthenticationProvider implements AuthenticationProvider {

  @Autowired
  UserService service;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    
    User user = service.selectByLogin(username);
    if (user == null) {
      throw new BadCredentialsException("user not exit");
    }
    if (!MyPasswordEncoder.passwordEncoder().matches(password, user.getPassword())) {
      throw new BadCredentialsException("password is error");
    }
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return new UsernamePasswordAuthenticationToken(user, password);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }
  
  
}
