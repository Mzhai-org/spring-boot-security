
package com.zs.springbootsecurity.bo;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: Msg.java, v1.0 2019/11/20 19:04 zhaishuo Exp $
 */
public class Msg {
  private String title;
  private String content;
  private String etraInfo;

  public Msg(String title, String content, String etraInfo) {
    super();
    this.title = title;
    this.content = content;
    this.etraInfo = etraInfo;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getEtraInfo() {
    return etraInfo;
  }
  public void setEtraInfo(String etraInfo) {
    this.etraInfo = etraInfo;
  }

}
