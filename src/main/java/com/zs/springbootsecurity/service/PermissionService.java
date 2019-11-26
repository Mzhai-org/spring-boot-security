
package com.zs.springbootsecurity.service;

import com.zs.springbootsecurity.bo.Permission;

import java.util.List;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: PermissionService.java, v1.0 2019/11/21 17:21 zhaishuo Exp $
 */
public interface PermissionService {
  
  List<Permission> selectByUsername(String username);
  
  List<Permission> selectByRole(Integer roleId);

  List<Permission> selectByRoleName(String roleName);

  int insert(Permission record);
}
