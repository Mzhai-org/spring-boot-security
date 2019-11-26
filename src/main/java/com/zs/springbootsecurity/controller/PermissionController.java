
package com.zs.springbootsecurity.controller;

import com.zs.springbootsecurity.bo.Permission;
import com.zs.springbootsecurity.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * @version $Id: PermissionController.java, v1.0 2019/11/26 18:50 zhaishuo Exp $
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
  
  @Autowired
  PermissionService permissionService;
  
  @PostMapping("/insertPermission")
  @PreAuthorize("hasAuthority('ADMIN')")
  public int insertPermission(@RequestBody Permission permission) {
     return permissionService.insert(permission);
  }
  
  
}
