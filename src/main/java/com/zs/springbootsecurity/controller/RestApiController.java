
package com.zs.springbootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: RestController.java, v1.0 2019/11/21 15:41 zhaishuo Exp $
 */
@RestController
public class RestApiController {
  
  
  @GetMapping("/admin")
//  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String hello() {
    return "Hello, world";
  }
  
}
