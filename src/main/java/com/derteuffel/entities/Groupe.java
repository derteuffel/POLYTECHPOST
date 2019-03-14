package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 14/03/2019.
 */
@Entity
public class Groupe implements Serializable{

    @Id
    @GeneratedValue
    private Long groupeId;
    private String groupeName;
    private String groupePicture;
    private Boolean groupeStatus;

    @ManyToMany
    private Set<User> users;

    @OneToMany(mappedBy = "groupe")
    private List<Post> posts;

    public Groupe() {
    }

    public Groupe(String groupeName, String groupePicture, Boolean groupeStatus) {
        this.groupeName = groupeName;
        this.groupePicture = groupePicture;
        this.groupeStatus = groupeStatus;
    }

    public Long getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Long groupeId) {
        this.groupeId = groupeId;
    }

    public String getGroupeName() {
        return groupeName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setGroupeName(String groupeName) {
        this.groupeName = groupeName;
    }

    public String getGroupePicture() {
        return groupePicture;
    }

    public void setGroupePicture(String groupePicture) {
        this.groupePicture = groupePicture;
    }

    public Boolean getGroupeStatus() {
        return groupeStatus;
    }

    public void setGroupeStatus(Boolean groupeStatus) {
        this.groupeStatus = groupeStatus;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
        user.getGroupes().remove(this);
    }
}
