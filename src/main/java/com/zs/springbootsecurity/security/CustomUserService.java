
package com.zs.springbootsecurity.security;

import com.zs.springbootsecurity.bo.User;
import com.zs.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: UserDetilServiceImpl.java, v1.0 2019/11/20 17:51 zhaishuo Exp $
 */
public class CustomUserService implements UserDetailsService {
  
  
  @Autowired
  UserService service;
  
  @Override
  public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {


    User user = service.selectByLogin(loginName);
    
    if (user == null) {
//      throw new UsernameNotFoundException("username : " + loginName + "not found!");
      throw new BadCredentialsException("Wrong username or password");
    }
    List<GrantedAuthority> authorities = 
        user.getRoles()
            .stream()
            .map(item -> new SimpleGrantedAuthority(item.getName()))
            .collect(Collectors.toList());
    UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), authorities);
    return userDetails;
  }
}
