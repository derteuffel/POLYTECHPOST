package com.derteuffel.repositories;

import com.derteuffel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 06/02/2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByDepartement(String departement);
    User findByEmail(String email);
    User findByNom(String nom);
}
