
package com.zs.springbootsecurity.service.impl;

import com.zs.springbootsecurity.bo.Permission;
import com.zs.springbootsecurity.mapper.PermissionMapper;
import com.zs.springbootsecurity.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: PermissionServiceImpl.java, v1.0 2019/11/21 17:22 zhaishuo Exp $
 */
@Service
public class PermissionServiceImpl implements PermissionService {
  
  @Autowired
  PermissionMapper mapper;
  
  @Override
  public List<Permission> selectByUsername(String username) {
    return mapper.selectByUsername(username);
  }

  @Override
  public List<Permission> selectByRole(Integer roleId) {
    return mapper.selectByRole(roleId);
  }

  @Override
  public List<Permission> selectByRoleName(String roleName) {
    return mapper.selectByRoleName(roleName);
  }
}
