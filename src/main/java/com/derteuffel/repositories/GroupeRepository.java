package com.derteuffel.repositories;

import com.derteuffel.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 14/03/2019.
 */
@Repository
public interface GroupeRepository extends JpaRepository<Groupe,Long>{

    List<Groupe> findByUsers_UserId(Long userId);

    Groupe findByGroupeName(String groupeName);

    List<Groupe> findAllByGroupeStatus(Boolean groupeStatus);
}
