package com.derteuffel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by derteuffel on 10/02/2019.
 */
@Entity
public class Post implements Serializable {
    @Id
   private Long postId;
}
