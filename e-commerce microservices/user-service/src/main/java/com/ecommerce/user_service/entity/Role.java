package com.ecommerce.user_service.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Role {
	@Id
	private int roleId;
	
	private String roleName;
	
	 @ManyToMany(mappedBy = "roles")  // Must match field name in User entity
	    private Set<User> users = new HashSet<>();
}
