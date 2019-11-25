
package com.zs.springbootsecurity.security.passwordencoder;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: PasswordEncoder.java, v1.0 2019/11/25 10:35 zhaishuo Exp $
 */
public class MyPasswordEncoder implements PasswordEncoder {
  
  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public String encode(CharSequence charSequence) {
    return this.passwordEncoder().encode(charSequence);
  }

  @Override
  public boolean matches(CharSequence charSequence, String s) {
    return this.passwordEncoder().matches(charSequence, s);
  }
}
