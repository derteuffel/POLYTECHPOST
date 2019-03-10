package com.derteuffel.repositories;

import com.derteuffel.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by neword on 10/03/2019.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
