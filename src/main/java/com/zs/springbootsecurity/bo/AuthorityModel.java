
package com.zs.springbootsecurity.bo;

import org.springframework.security.core.GrantedAuthority;

/**
 * <pre>
 *    描述信息
 * </pre>
 *
 * @author zhaishuo
 * @version $Id: AuthorityModel.java, v1.0 2019/11/25 19:18 zhaishuo Exp $
 */
public class AuthorityModel implements GrantedAuthority {

  private static final long serialVersionUID = -3774998555435352628L;

  /** generally used fields**/
  private String permissionId;

  private String permissionName;

  private String subjectId;

  /**
   * @return the permissionId
   */
  public String getPermissionId() {
    return permissionId;
  }

  /**
   * @param permissionId the permissionId to set
   */
  public void setPermissionId(String permissionId) {
    this.permissionId = permissionId;
  }

  /**
   * @return the permissionName
   */
  public String getPermissionName() {
    return permissionName;
  }

  /**
   * @param permissionName the permissionName to set
   */
  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }

  /**
   * @return the subjectId
   */
  public String getSubjectId() {
    return subjectId;
  }

  /**
   * @param subjectId the subjectId to set
   */
  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  @Override
  public String getAuthority() {
    return subjectId == null ? permissionName : permissionName + ":" + subjectId;
  }
}

