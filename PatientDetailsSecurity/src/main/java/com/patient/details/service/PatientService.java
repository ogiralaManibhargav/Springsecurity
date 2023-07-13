package com.patient.details.service;

import com.patient.details.request.PatientRequest;
import com.patient.details.response.PatientResponse;

public interface PatientService {

	void savePatient(PatientRequest patientRequest);

	PatientResponse retrievePatientbyId(Long id);

}
