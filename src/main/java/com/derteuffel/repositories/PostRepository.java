package com.derteuffel.repositories;

import com.derteuffel.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 10/03/2019.
 */

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("select p from Post as p join p.user pu where pu.userId=:id order by p.postId desc")
    List<Post> findAllByUser(@Param("id") Long userId);

    @Query("select p from Post as p join p.groupe pg where pg.groupeId=:id order by p.postId desc")
    List<Post> findAllByGroupe(@Param("id") Long groupeId);
}
