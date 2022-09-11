package com.liufei.mall.tiny.model;

import com.liufei.mall.seed.model.UmsAdminDOV1;
import com.liufei.mall.seed.model.UmsPermissionDOV1;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liufei
 * @version 1.0.0
 * @description SpringSecurity需要的用户详情
 * @date 2022/9/11
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdminDOV1 umsAdmin;
    private List<UmsPermissionDOV1> permissionList;

    public AdminUserDetails(UmsAdminDOV1 umsAdmin, List<UmsPermissionDOV1> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getValue() != null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return umsAdmin.getStatus().equals(1);
    }
}
