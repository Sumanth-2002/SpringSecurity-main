package com.ust.SpringSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @NotBlank(message = "Name cannot be blank")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

//    @NotBlank(message = "Email cannot be blank")
//    @Email(message = "Email should be valid")
    private String email;

//    @NotBlank(message = "Password cannot be blank")
//    @Pattern(
//            regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
//            message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character"
//    )
    private String password;

//    @NotBlank(message = "Roles cannot be blank")
//    @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$", message = "Role must be one of ROLE_ADMIN or ROLE_USER")
  private  String roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name cannot be blank") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be blank") @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email cannot be blank") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password cannot be blank") @Pattern(
            regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character"
    ) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password cannot be blank") @Pattern(
            regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = "Password must include at least one uppercase letter, one lowercase letter, one number, and one special character"
    ) String password) {
        this.password = password;
    }

    public @NotBlank(message = "Roles cannot be blank") @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$", message = "Role must be one of ROLE_ADMIN or ROLE_USER") String getRoles() {
        return roles;
    }

    public void setRoles(@NotBlank(message = "Roles cannot be blank") @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$", message = "Role must be one of ROLE_ADMIN or ROLE_USER") String roles) {
        this.roles = roles;
    }
}
