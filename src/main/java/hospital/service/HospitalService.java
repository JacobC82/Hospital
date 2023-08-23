package hospital.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import hospital.controller.model.HospitalData;
import hospital.controller.model.HospitalPatient;
import hospital.controller.model.HospitalStaff;
import hospital.dao.HospitalDao;
import hospital.dao.PatientDao;
import hospital.dao.StaffDao;
import hospital.entity.Hospital;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;
//	@Autowired
//	private StaffDao staffDao;
//	@Autowired
//	private PatientDao patientDao;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	public HospitalStaff saveStaff(Long hospitalId, HospitalStaff hospitalStaff) {
		// TODO Auto-generated method stub
		return null;
	}

}
