
package com.zs.springbootsecurity.security;

import org.springframework.context.annotation.Primary;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: CustomInvocationSecurityMetadataSourceService.java, v1.0 2019/11/21 17:49 zhaishuo Exp $
 */
@Service
@Primary
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
  
  //此方法是为了将除了登录url和静态资源之外的所有请求uel 返回给decide方法 判断当前用户是否有权限访问。
  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    
    FilterInvocation request = (FilterInvocation) object;
    String url = request.getRequestUrl();
    if (url.equals("/login") || url.startsWith("/css") || url.startsWith("/js")) {
      return null;
    }
    ConfigAttribute cfg = new SecurityConfig(url);
    Collection<ConfigAttribute> array = new ArrayList<>();
    array.add(cfg);
    
    return array;
  }

  @Override
  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return true;
  }
}
