package com.patient.details.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.details.models.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
