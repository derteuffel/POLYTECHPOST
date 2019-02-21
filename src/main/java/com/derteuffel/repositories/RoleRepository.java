package com.derteuffel.repositories;

import com.derteuffel.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by derteuffel on 06/02/2019.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    Collection<Role> findByUsers_UserId(Long userId);
}
