package com.derteuffel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by derteuffel on 10/02/2019.
 */
@Entity
public class Post implements Serializable {
    @Id
    private Long postId;
    private Long postTitle;
    private Long postDescription;
    private Date postDate;

}
