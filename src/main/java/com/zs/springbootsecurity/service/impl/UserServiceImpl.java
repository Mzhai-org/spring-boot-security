
package com.zs.springbootsecurity.service.impl;

import com.zs.springbootsecurity.bo.User;
import com.zs.springbootsecurity.mapper.UserMapper;
import com.zs.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: UserServiceImpl.java, v1.0 2019/11/21 17:24 zhaishuo Exp $
 */
@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  UserMapper mapper;
  
  @Override
  public User selectByLogin(String username) {
    return mapper.selectByLogin(username);
  }
}
