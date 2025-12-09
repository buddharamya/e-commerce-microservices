package com.microserviceprojects.user_service.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class CredentialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer credentialId;

    @Column(unique=true)
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private RoleBasedAuthority roleBasedAuthority;

//    @JsonIgnore  // this annotation is for the child table to avoid recursion
    @JsonIgnoreProperties("credential")
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id",unique=true,nullable=false)
    private UserEntity user;
}
