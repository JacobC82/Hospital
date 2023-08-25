package hospital.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hospital.controller.model.HospitalData;
import hospital.controller.model.HospitalPatient;
import hospital.controller.model.HospitalStaff;
import hospital.dao.HospitalDao;
import hospital.dao.PatientDao;
import hospital.dao.StaffDao;
import hospital.entity.Hospital;
import hospital.entity.Patient;
import hospital.entity.Staff;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private PatientDao patientDao;
	
	public HospitalData saveHospitalData(HospitalData hospitalData) {
		Hospital hospital = findOrCreateHospital(hospitalData.getHospitalId());
		
		copyHospitalFields(hospital, hospitalData);
		
		Hospital hospitalDAO = hospitalDao.save(hospital);
		
		return new HospitalData(hospitalDAO);
	}

	private void copyHospitalFields(Hospital hospital, HospitalData hospitalData) {
		hospital.hospitalId = hospitalData.getHospitalId();
		hospital.hospitalName = hospitalData.getHospitalName();
		hospital.hospitalAddress = hospitalData.getHospitalAddress();
		hospital.hospitalCity = hospitalData.getHospitalCity();
		hospital.hospitalState = hospitalData.getHospitalState();
		hospital.hospitalZip = (hospitalData.getHospitalZip());
		hospital.hospitalPhone = hospitalData.getHospitalPhone();
	}

	private Hospital findOrCreateHospital(Long hospitalId) {
	Hospital hospital;
		
		if(Objects.isNull(hospitalId)) {
			hospital = new Hospital();
		}
		else {
			hospital = findHospitalById(hospitalId);
		}
		return hospital;
	}

	private Hospital findHospitalById(Long hospitalId) {
		return hospitalDao.findById(hospitalId).orElseThrow(()
				-> new NoSuchElementException("Hospital with ID = " 
						+ hospitalId + " is not a valid ID number."));
	}

	public HospitalPatient savePatient(Long hospitalId, HospitalPatient hospitalPatient) {
		Hospital hospital = findHospitalById(hospitalId);
		Long patientId = hospitalPatient.getPatientId();
		Patient patient = findOrCreatePatient(patientId, hospitalId);
		
		copyPatientFields(patient, hospitalPatient);
		
		patient.getHospital().add(hospital);
		hospital.getPatients().add(patient);
		
		Patient dbPatient = patientDao.save(patient);
		
		return new HospitalPatient(dbPatient);
	}
	
	private void copyPatientFields(Patient patient, HospitalPatient hospitalPatient) {
		patient.setPatientId(hospitalPatient.getPatientId());
		patient.setPatientFirstName(hospitalPatient.getPatientFirstName());
		patient.setPatientLastName(hospitalPatient.getPatientLastName());
		patient.setPatientPhone(hospitalPatient.getPatientPhone());
	}

	private Patient findOrCreatePatient(Long patientId, Long hospitalId) {
			if (patientId == null){
			System.out.println("no patient found!");
			return new Patient();
		}
		return findCustomerById(hospitalId, patientId);
	}

	private Patient findCustomerById(Long hospitalId, Long patientId) {
		Patient patient = patientDao.findById(patientId).orElseThrow(() -> new NoSuchElementException("No patient with Id= " + patientId + " in pet store " + hospitalId));
		
		for(Hospital hospital : patient.getHospital()) {
			if(hospital.getHospitalId()== hospitalId) {
				return patient;
			}
		}throw new IllegalArgumentException("No such patient for hospital ID= " + hospitalId);
		
	}	

	@Transactional(readOnly = false)
	public HospitalStaff saveStaff(Long hospitalId, HospitalStaff hospitalStaff) {
		Hospital hospital = findHospitalById(hospitalId);
		
		Long staffId = hospitalStaff.getStaffId();
		
		Staff staff = findOrCreateStaff(hospitalId, staffId);
		
		copyStaffFields(staff, hospitalStaff);
		
		staff.setHospital(hospital);

		hospital.getStaffers().add(staff);
		
		Staff dbStaff = staffDao.save(staff);
		
		return new HospitalStaff(dbStaff);
	}

	private void copyStaffFields(Staff staff, HospitalStaff hospitalStaff) {
		staff.setStaffId(hospitalStaff.getStaffId());
		staff.setStaffFirstName(hospitalStaff.getStaffFirstName());
		staff.setStaffLastName(hospitalStaff.getStaffLastName());
		staff.setStaffPhone(hospitalStaff.getStaffPhone());
		staff.setStaffJobTitle(hospitalStaff.getStaffJobTitle());
	}

	private Staff findOrCreateStaff(Long hospitalId, Long staffId) {
		if(Objects.isNull(staffId)) {
			return new Staff();
			}
			return findStaffById(hospitalId, staffId);
	}

	private Staff findStaffById(Long hospitalId, Long staffId) {
		Staff staff =  staffDao.findById(staffId).orElseThrow(() -> new NoSuchElementException("Hospital with ID= "
				+ hospitalId + " does not have an employee with employee ID= " + staffId + "."));
		
		if(staffId == staff.getHospital().getHospitalId()) {
			return staff;
		}else {
			throw new IllegalArgumentException("No such staff member ID for a hospitil with ID= " + hospitalId);
		}
	}

	@Transactional(readOnly = true)
	public List<HospitalData> retrieveAllHospitals() {
		List<Hospital> hospitals = hospitalDao.findAll();
		List<HospitalData> result = new LinkedList<>();
		
		for(Hospital hospital : hospitals) {
			HospitalData hospitalData = new HospitalData(hospital);
				hospitalData.getHospitalStaffers().clear();
				hospitalData.getHospitalPatients().clear();		
				result.add(hospitalData);
		}
		return result;
	}
	
	@Transactional
	public HospitalData retrieveHospitalById(Long hospitalId) {
		Optional<Hospital> optHosptial =  hospitalDao.findById(hospitalId);
		Hospital hospital = optHosptial.get();
		return new HospitalData(hospital);
	}

	private Patient findPatientById (Long patientId) {
		return patientDao.findById(patientId).orElseThrow(()
				-> new NoSuchElementException("Pet store with ID = " 
						+ patientId + " is not a valid ID number."));
	}
	
	@Transactional
	public HospitalPatient retrievePatientById(Long patientId) {
		Optional<Patient> optPatient =  patientDao.findById(patientId);
		Patient patient = optPatient.get();
		return new HospitalPatient(patient);
	}
	
	@Transactional (readOnly = false)
	public void deletePatientById(Long patientId) {
		Patient patient = findPatientById(patientId);
		patientDao.delete(patient);
	}
	
}
