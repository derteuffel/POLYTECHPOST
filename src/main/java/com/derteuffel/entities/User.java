package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by derteuffel on 06/02/2019.
 */
@Entity
public class User implements Serializable {

    private Long userId;
    private String nom;
    private String prenom;
    private String matricul;
    private String telephone;
    private String avatar;
    private String email;
    private String password;
    private String departement;
    private Boolean active;
    private String resetToken;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(Long userId, String nom, String prenom, String matricul, String telephone,
                String avatar, String email, String password, String departement, Boolean active, Collection<Role> roles, String resetToken) {
        this.userId = userId;
        this.nom = nom;
        this.resetToken=resetToken;
        this.prenom = prenom;
        this.matricul = matricul;
        this.telephone = telephone;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.departement = departement;
        this.active = active;
        this.roles = roles;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricul() {
        return matricul;
    }

    public void setMatricul(String matricul) {
        this.matricul = matricul;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void addRoles(Role role){
        roles.add(role);
    }
}
