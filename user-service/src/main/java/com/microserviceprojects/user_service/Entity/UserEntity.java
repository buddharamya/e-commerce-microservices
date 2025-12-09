package com.microserviceprojects.user_service.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @JsonIgnoreProperties("user")   // hide parent reference only
    @OneToOne(mappedBy = "user", cascade=CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval = true)
    private CredentialEntity credential;
}
