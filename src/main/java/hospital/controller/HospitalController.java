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
import hospital.service.HospitalService;
import lombok.extern.slf4j.Slf4j;

//import pet.store.controller.model.PetStoreCustomer;
//import pet.store.controller.model.PetStoreData;
//import pet.store.controller.model.PetStoreEmployee;
//import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/hospital")
@Slf4j
public class HospitalController{

	@Autowired
	private HospitalService hospitalService;	
	
	@PostMapping("hospital")
	@ResponseStatus(code = HttpStatus.CREATED)
	public HospitalData insertHospitalData(@RequestBody HospitalData hospitalData) {
		
		log.info("Creating hospital data {}", hospitalData);
		
		return hospitalService.saveHospitalData(hospitalData);
		
	}
//	
//	@PutMapping("/pet_store/{petStoreId}")
//	public PetStoreData updatePetStore(@PathVariable Long petStoreId,
//									@RequestBody PetStoreData petStoreData) {
//		
//		petStoreData.setPetStoreId(petStoreId);
//		
//		log.info("Updating Pet Store {}", petStoreData);
//		
//		return petStoreService.savePetStoreData(petStoreData);
//		
//	}
	@PostMapping("/{hospitalId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED) //PetStoreEmployee employeeId changed to what it is now (petStoreEmoloyee)
	public HospitalStaff addStaff(@PathVariable Long hospitalId, @RequestBody HospitalStaff hospitalStaff) {
		
		
		log.info("Adding staff member {} to hospital ={}" , hospitalStaff, hospitalId );
		
		return hospitalService.saveStaff(hospitalId, hospitalStaff);
	}

	@PostMapping("/{hospitalId}/patient")
	@ResponseStatus(code = HttpStatus.CREATED) 
	public HospitalPatient addPatient(@PathVariable Long hospitalId, @RequestBody HospitalPatient hospitalPatient) {
	
	
	log.info("Adding patient {} to hospital ={}", hospitalPatient, hospitalId);
	
	return hospitalService.savePatient(hospitalId, hospitalPatient);
	}
//	
//	
//	@GetMapping
//	public List<PetStoreData> listAllPetStores (){
//		return petStoreService.retrieveAllPetStores();
//	}
//	
//	@GetMapping("/{petStoreId}")
//	public PetStoreData listPetStoreById(@PathVariable Long petStoreId){
//		return petStoreService.retrievePetStoreByID(petStoreId);
//	}
//	
//	@DeleteMapping("/{petStoreId}")
//	public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId){
//
//		log.info("Deleting pet store with ID= {}", petStoreId);
//		
//		petStoreService.deletePetStoreById(petStoreId);
//		
//		return Map.of("message", "Deletion of pet store " + petStoreId + " is successful.");
//	}
}
