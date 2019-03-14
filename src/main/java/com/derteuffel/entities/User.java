package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 06/02/2019.
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long userId;
    private String nom;
    private String prenom;
    private String matricule;
    private String telephone;
    private String avatar;
    private String email;
    private String password;
    private String departement;
    private Boolean active;
    private String resetToken;
    private String type;
    private Boolean status;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    @ManyToMany(mappedBy = "users")
    private Set<Groupe> groupes;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
    }

    public User(Long userId, String nom, String prenom, String matricule, String telephone,
                String avatar, String email,String type, String password,Boolean status, String departement, Boolean active, Collection<Role> roles, String resetToken) {
        this.userId = userId;
        this.nom = nom;
        this.resetToken=resetToken;
        this.prenom = prenom;
        this.status=status;
        this.type=type;
        this.matricule = matricule;
        this.telephone = telephone;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.departement = departement;
        this.active = active;
        this.roles = roles;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
