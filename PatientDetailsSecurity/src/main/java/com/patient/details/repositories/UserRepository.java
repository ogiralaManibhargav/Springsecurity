package com.patient.details.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.details.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

	  Boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	//  Boolean existsByEmail(String email);

}
