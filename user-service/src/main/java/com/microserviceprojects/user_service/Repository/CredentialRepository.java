package com.microserviceprojects.user_service.Repository;

import com.microserviceprojects.user_service.Entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<CredentialEntity, Integer> {

    Optional<CredentialEntity> findByUserName(String username);
}
