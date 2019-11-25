
package com.zs.springbootsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: CommonConfiguration.java, v1.0 2019/11/25 18:12 zhaishuo Exp $
 */
@Configuration
public class CommonConfiguration {

//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return  NoOpPasswordEncoder.getInstance();
  }
  
}
