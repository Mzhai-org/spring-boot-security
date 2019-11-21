
package com.zs.springbootsecurity.security;

import com.zs.springbootsecurity.bo.Permission;
import com.zs.springbootsecurity.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: CustomAccessDecisionManager.java, v1.0 2019/11/21 17:38 zhaishuo Exp $
 */
@Service
@Primary
public class CustomAccessDecisionManager implements AccessDecisionManager {

  @Autowired
  PermissionService permissionService;
  
  // decide 方法是判定是否拥有权限的决策方法，
  //authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
  //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
  //configAttributes 为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行

  @Override
  public void decide(Authentication authentication, Object o, 
                     Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
    if (configAttributes == null || configAttributes.size() <= 0) {
      return;
    }
    for (ConfigAttribute item: configAttributes) {
      String url = item.getAttribute();
      for (GrantedAuthority ga: authentication.getAuthorities()) {
        String auth = ga.getAuthority();
        List<Permission> permissions = permissionService.selectByRoleName(auth);

        for (Permission p: permissions) {
          if (url.trim().equals(p.getUrl())) {
            return;
          }
        }
      }
    }
   throw new AccessDeniedException("no right"); 
  }

  @Override
  public boolean supports(ConfigAttribute configAttribute) {
    return true;
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return true;
  }
}
