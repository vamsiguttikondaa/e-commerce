package com.ecommerce.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.user_service.entity.Address;
@Repository
public interface AdressRepository extends JpaRepository<Address, Long> {

}
