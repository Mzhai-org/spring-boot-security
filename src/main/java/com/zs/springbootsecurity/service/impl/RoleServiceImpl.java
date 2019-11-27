
package com.zs.springbootsecurity.service.impl;

import com.zs.springbootsecurity.bo.Role;
import com.zs.springbootsecurity.mapper.RoleMapper;
import com.zs.springbootsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: RoleServiceImpl.java, v1.0 2019/11/27 11:07 zhaishuo Exp $
 */
@Service
public class RoleServiceImpl implements RoleService {
 
  @Autowired
  RoleMapper roleMapper;
  
 
  @Override
  public int insert(Role record) {
    return roleMapper.insert(record);
  }
}
