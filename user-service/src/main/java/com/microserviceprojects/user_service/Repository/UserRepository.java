package com.microserviceprojects.user_service.Repository;

import com.microserviceprojects.user_service.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // DSL (Domain Specific Language methods)
    @Query("SELECT u from UserEntity u where u.credential.userName = :userName")
    Optional<UserEntity> findByCredentialUserName(@Param("userName") String userName);

    UserEntity findByEmail(String email);

}
