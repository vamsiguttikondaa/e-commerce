package com.ecommerce.user_service.payloads;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDto {
    private String name;
    private String email;
    private String password;
    private String phone;
 
    
}
