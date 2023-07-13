package com.patient.details.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.details.models.Patient;
import com.patient.details.repositories.PatientRepository;
import com.patient.details.request.PatientRequest;
import com.patient.details.response.PatientResponse;
import com.patient.details.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void savePatient(PatientRequest patientRequest) {
		
		Patient patient = new Patient();
		if(patientRequest!=null)
		{
			BeanUtils.copyProperties(patientRequest, patient);
			patient.setIsActive("Y");
			patientRepository.save(patient);
		}
		
	}

	@Override
	public PatientResponse retrievePatientbyId(Long id) {
		
		PatientResponse response = new PatientResponse();
		Optional<Patient> findById = patientRepository.findById(id);
		if(findById.isPresent())
		{
			BeanUtils.copyProperties(findById.get(), response);
		}
		return response;
	}

}
