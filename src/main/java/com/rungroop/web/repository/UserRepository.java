package com.rungroop.web.repository;

import com.rungroop.web.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);

    UserEntity findFirstByUsername(String username);

    UserEntity findByUsername(String username);
}
