package com.derteuffel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by derteuffel on 10/02/2019.
 */
@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue
    private Long postId;
    private String postTitle;
    private String postDescription;
    private Date postDate;
    private ArrayList<String> pieces;

    @ManyToOne
    private Groupe groupe;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(String postTitle, String postDescription, Date postDate, ArrayList<String> pieces) {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.postDate = postDate;
        this.pieces = pieces;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public ArrayList<String> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<String> pieces) {
        this.pieces = pieces;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
