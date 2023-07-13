package com.patient.details.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.details.models.ERole;
import com.patient.details.models.Role;

@Repository
public interface RoleRepositories extends JpaRepository<Role, Long>  {
	Optional<Role> findByName(ERole name);

}
