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
import org.springframework.web.bind.annotation.ResponseStatus;

//import pet.store.controller.model.PetStoreCustomer;
//import pet.store.controller.model.PetStoreData;
//import pet.store.controller.model.PetStoreEmployee;
//import pet.store.service.PetStoreService;

public class HospitalController {
	
//	@Autowired
//	private PetStoreService petStoreService;	
//	
//	@PostMapping("pet_store")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public PetStoreData insertPetStoreData(@RequestBody PetStoreData petStoreData) {
//		
//		log.info("Creating pet store data {}", petStoreData);
//		
//		return petStoreService.savePetStoreData(petStoreData);
//		
//	}
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
//	@PostMapping("/{petStoreId}/employee")
//	@ResponseStatus(code = HttpStatus.CREATED) //PetStoreEmployee employeeId changed to what it is now (petStoreEmoloyee)
//	public PetStoreEmployee addEmployee(@PathVariable Long petStoreId, @RequestBody PetStoreEmployee petStoreEmployee) {
//		
//		
//		log.info("Adding employee {} to pet store ={}" , petStoreEmployee, petStoreId );
//		
//		return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
//	}
//
//	@PostMapping("/{petStoreId}/customer")
//	@ResponseStatus(code = HttpStatus.CREATED) 
//	public PetStoreCustomer addCustomer(@PathVariable Long petStoreId, @RequestBody PetStoreCustomer petStoreCustomer) {
//	
//	
//	log.info("Adding customer {} to pet store ={}", petStoreCustomer, petStoreId);
//	
//	return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
//	}
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
