package com.zs.springbootsecurity.mapper;

import com.zs.springbootsecurity.bo.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> selectByRole(Integer roleId);
    
    List<Permission> selectByRoleName(String roleName);
    
    List<Permission> selectByUsername(String usernname);
    
    List<Permission> findAll();
}