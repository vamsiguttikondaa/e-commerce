package com.ecommerce.user_service.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@Setter
@Getter
public class User {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    private String phone;

	    private String address;

	    private boolean enabled = true;

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;
	    

	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "user_roles",
	        joinColumns = @JoinColumn(name = "user_id"),        // Foreign key in join table for User
	        inverseJoinColumns = @JoinColumn(name = "role_id")  // Foreign key in join table for Role
	    )
	    private Set<Role> roles = new HashSet<>();
	    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<Address> adress=new HashSet<>();
}
