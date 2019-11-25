
package com.zs.springbootsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: OAuth2ResourceConfig.java, v1.0 2019/11/25 12:00 zhaishuo Exp $
 */
@Configuration
@EnableResourceServer
@Profile("JWTAuthCore")
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(
            "/**/*.jpg", "/**/*.jpeg", "/**/*.png", "/**/*.html", "/**/*.css", "/**/*.js", "/**/*.ttf",
            "/**/*.woff*", "/**/*.ico", "/assets/**", "/noauth/**", "/users/status", "/users/answer",
            "/users/reset", "/users/password-strategy", "/users/change/password", "/users/forget/password/*",
            "/reference/question/data", "/users/reset/password", "/saml/**","/swagger/**","/actuator/**")
        .permitAll().anyRequest().authenticated();
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer config) {
    config.tokenStore(tokenStore());
  }

  @Bean
  public TokenStore tokenStore() {
    return new JwtTokenStore(accessTokenConverter());
  }

  @Bean
  public JwtAccessTokenConverter accessTokenConverter() {
    return new JwtAccessTokenConverter();
  }
}