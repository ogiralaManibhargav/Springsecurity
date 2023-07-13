package com.patient.details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.details.request.PatientRequest;
import com.patient.details.response.PatientResponse;
import com.patient.details.service.PatientService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/api/test")
@SecurityRequirement(name = "Test")
public class TestController {
	@Autowired
	private PatientService patientService;
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
  @GetMapping("/Hi")
 // @PreAuthorize("hasRole('ADMIN')")
  public String Hi() {
    return "Hello";
  }
//  @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
  @PostMapping("/addPatient")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String savePatient(@RequestBody PatientRequest patientRequest)
  {
	  patientService.savePatient(patientRequest);
	return null;
	  
  }
 // @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
  @GetMapping("/getpatient/{id}")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public PatientResponse getPatientyId(@PathVariable Long id)
  {
	  
	return patientService.retrievePatientbyId(id);
	  
  }
}
