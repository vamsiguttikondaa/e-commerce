package com.ecommerce.user_service.payloads;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private boolean enabled;
    private Set<String> roles; // or RoleDto
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
 
}