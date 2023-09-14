package hospital.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hospital.controller.model.HospitalData;
import hospital.controller.model.HospitalPatient;
import hospital.controller.model.HospitalStaff;
import hospital.entity.Patient;
import hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hospital")
@Slf4j
public class HospitalController{
	@Autowired
	private HospitalService hospitalService;	
	
	@PostMapping("/hospital")
	@ResponseStatus(code = HttpStatus.CREATED)
	public HospitalData insertHospitalData(@RequestBody HospitalData hospitalData) {
		log.info("Creating hospital data {}", hospitalData);
		
		return hospitalService.saveHospitalData(hospitalData);
	}
	
	@PutMapping("/hospital/{hospitalId}")
	public HospitalData updateHospital(@PathVariable Long hospitalId, @RequestBody HospitalData hospitalData) {
		hospitalData.setHospitalId(hospitalId);
		
		log.info("Updating Hospital {}", hospitalData);
		
		return hospitalService.saveHospitalData(hospitalData);
	}

	@PutMapping("/{hospitalId}/{patientId}")
	public HospitalPatient updatePatient(@PathVariable Long patientId, @PathVariable Long hospitalId,
		@RequestBody HospitalPatient hospitalPatient) {
		hospitalPatient.setPatientId(patientId);
		
		log.info("Updating patients {}", hospitalPatient);
		
		return hospitalService.savePatient(hospitalId, hospitalPatient);
	}

	@PostMapping("/{hospitalId}/staff")
	@ResponseStatus(code = HttpStatus.CREATED)
	public HospitalStaff addStaff(@PathVariable Long hospitalId, @RequestBody HospitalStaff hospitalStaff) {
		log.info("Adding staff member {}" , hospitalStaff, hospitalId );
		
		return hospitalService.saveStaff(hospitalId, hospitalStaff);
	}

	@PostMapping("/{hospitalId}/patient")
	@ResponseStatus(code = HttpStatus.CREATED) 
	public HospitalPatient addPatient(@PathVariable Long hospitalId, @RequestBody HospitalPatient hospitalPatient) {
	log.info("Adding patient {} to hospital ={}", hospitalPatient, hospitalId);
	
	return hospitalService.savePatient(hospitalId, hospitalPatient);
	}
	
	@GetMapping
	public List<HospitalData> listAllHospitals (){
		return hospitalService.retrieveAllHospitals();
	}
	
	@GetMapping("/hospital/{hospitalId}")
	public HospitalData listHospitalById(@PathVariable Long hospitalId){
		return hospitalService.retrieveHospitalById(hospitalId);
	}
	
	@GetMapping("/patients")
	public List<HospitalPatient> listAllPatients (){
		return hospitalService.retrieveAllPatients();
	}
	
	@GetMapping("/patient/{patientId}")
	//from HosptialPatient to Patient
	public HospitalPatient listPatientById(@PathVariable Long patientId){
		return hospitalService.retrievePatientById(patientId);
	}

	@DeleteMapping("/{hospitalId}/{patientId}")
	public Map<String, String> deletePatient(@PathVariable Long hospitalId,@PathVariable Long patientId){

		log.info("Deleting patient with ID= {}", patientId);
		
		hospitalService.deletePatientById(hospitalId, patientId);
		
		return Map.of("message", "Deletion of patient " + patientId + " is successful.");
	}
}
