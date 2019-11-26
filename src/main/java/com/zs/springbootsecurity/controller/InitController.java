
package com.zs.springbootsecurity.controller;

import com.zs.springbootsecurity.bo.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: InitController.java, v1.0 2019/11/20 17:50 zhaishuo Exp $
 */
/*
* deprecated api
* */
@Controller
public class InitController {
  
  @GetMapping("/")
  public String init(Model model) {
    Msg msg = new Msg("测试标题","测试内容","额外信息，只对管理员显示");
    model.addAttribute("msg", msg);
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
