
package com.zs.springbootsecurity.service;

import com.zs.springbootsecurity.bo.User;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: UserService.java, v1.0 2019/11/21 17:24 zhaishuo Exp $
 */
public interface UserService {
  int insert(User record);
  
  User selectByLogin(String username);
}
