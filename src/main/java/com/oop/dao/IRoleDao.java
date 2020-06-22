package com.oop.dao;

import com.oop.entities.Role;
import com.oop.models.ERole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
