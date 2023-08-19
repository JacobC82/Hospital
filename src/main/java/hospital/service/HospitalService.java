package hospital.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import hospital.controller.model.HospitalData;
import hospital.dao.HospitalDao;
import hospital.entity.Hospital;

public class HospitalService {

	public HospitalData saveHospitalData(HospitalData hospitalData) {
		Hospital hospital = findOrCreateHospital(hospitalData.getHospitalId());
		
		copyHospitalFields(hospital, hospitalData);
		
		Hospital hospitalDao =  hospitalDao.save(hospital);
		
		return new HospitalData(hospitalDao);
		
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

}
