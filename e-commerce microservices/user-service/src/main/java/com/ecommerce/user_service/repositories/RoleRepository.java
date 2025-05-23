package com.ecommerce.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.user_service.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
