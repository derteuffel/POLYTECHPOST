package com.derteuffel.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by derteuffel on 06/02/2019.
 */
@Entity
public class Role implements Serializable {
    private Long roleId;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role() {
    }

    public Role(Long roleId, String name, Collection<User> users) {
        this.roleId = roleId;
        this.name = name;
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
