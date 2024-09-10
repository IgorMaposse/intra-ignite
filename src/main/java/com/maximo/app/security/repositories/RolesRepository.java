package com.maximo.app.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maximo.app.security.models.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer>{

}
