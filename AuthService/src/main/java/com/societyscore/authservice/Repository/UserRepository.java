package com.societyscore.authservice.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.societyscore.authservice.Model.Entities.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	
    Optional<User> findByUsername(String username);
    
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

}
