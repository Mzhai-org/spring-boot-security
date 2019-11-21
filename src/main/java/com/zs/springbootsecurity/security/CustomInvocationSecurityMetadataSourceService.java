
package com.zs.springbootsecurity.security;

import com.zs.springbootsecurity.bo.Permission;
import com.zs.springbootsecurity.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
  
  @Autowired
  private PermissionMapper permissionDao;

  private HashMap<String, Collection<ConfigAttribute>> map =null;

  /**
   * 加载权限表中所有权限
   */
  public void loadResourceDefine(){
    map = new HashMap<>();
    Collection<ConfigAttribute> array;
    ConfigAttribute cfg;
    List<Permission> permissions = permissionDao.findAll();
    for(Permission permission : permissions) {
      array = new ArrayList<>();
      cfg = new SecurityConfig(permission.getName());
      //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
      array.add(cfg);
      //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
      map.put(permission.getUrl(), array);
    }

  }

  //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
  @Override
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    //if(map ==null) loadResourceDefine();
    //object 中包含用户请求的request 信息
//    HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
//    AntPathRequestMatcher matcher;
//    String resUrl;
//    for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
//      resUrl = iter.next();
//      matcher = new AntPathRequestMatcher(resUrl);
//      if(matcher.matches(request)) {
//        return map.get(resUrl);
//      }
//    }
    
    FilterInvocation request = (FilterInvocation) object;
    String url = request.getRequestUrl();
    if (url.equals("/login") || url.equals("/css/bootstrap.min.css")) {
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
