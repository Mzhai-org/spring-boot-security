

package com.zs.springbootsecurity.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: CustomExceptionHandler.java, v1.0 2019/11/22 16:17 zhaishuo Exp $
 */
@Component
@Primary
public class CustomAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomAuthenctiationFailureHandler.class);
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, 
                                      AuthenticationException exception) throws IOException, ServletException {
    /* 默认：执行重定向或转发到defaultfailureurl(如果设置)，Otherw返回401错误代码 */
    //super.onAuthenticationFailure(request,response,exception)
    request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception.getMessage());
//    request.getRequestDispatcher("/login?error").forward(request, response);
    this.redirectStrategy.sendRedirect(request, response, "/login?error");
    logger.error("登录错误 [{}] ",exception.getMessage());
//    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//    PrintWriter writer = response.getWriter();
//    writer.write(exception.getMessage());
//    writer.flush();
//    writer.close();
  }

}
