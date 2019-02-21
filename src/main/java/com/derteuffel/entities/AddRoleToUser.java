package com.derteuffel.entities;

import java.util.Collection;

/**
 * Created by derteuffel on 06/02/2019.
 */
public class AddRoleToUser {

    private Long userId;
    private Long roleId;
    private Collection<Role> roles;
    private User user;

    public AddRoleToUser() {
    }
    public AddRoleToUser(Collection<Role> roles, User user){
        this.user=user;
        this.roles=roles;
    }

    public AddRoleToUser(Long userId, Long roleId, Collection<Role> roles, User user) {
        this.userId = userId;
        this.roleId = roleId;
        this.roles = roles;
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
