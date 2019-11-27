
package com.zs.springbootsecurity.controller;

import com.zs.springbootsecurity.bo.Role;
import com.zs.springbootsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: RoleController.java, v1.0 2019/11/27 10:49 zhaishuo Exp $
 */
@RestController
@RequestMapping("/role")
public class RoleController {
  
  
  @Autowired
  RoleService roleService;
  
  @PostMapping("/insertRole")
  public int insertRole(@RequestBody Role record) {
    return roleService.insert(record);
  }
  
}
