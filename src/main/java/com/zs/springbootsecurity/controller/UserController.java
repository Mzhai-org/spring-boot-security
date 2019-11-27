
package com.zs.springbootsecurity.controller;

import com.zs.springbootsecurity.bo.User;
import com.zs.springbootsecurity.service.UserService;
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
 * @version $Id: UserController.java, v1.0 2019/11/27 11:05 zhaishuo Exp $
 */
@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  UserService userService;
  
  @PostMapping("/register")
  public int register(@RequestBody User record) {
    return userService.insert(record);
  }
  
}
