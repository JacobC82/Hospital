package hospital.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.entity.Hospital;
import hospital.entity.Patient;
import hospital.entity.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class HospitalData {
	
	private Long hospitalId;
	private String hospitalName;
	private String hospitalAddress;
	private String hospitalCity;
	private String hospitalState;
	private String hospitalZip;
	private String hospitalPhone;
	
	private Set<HospitalPatient> hospitalPatients = new HashSet<>();
	private Set<HospitalStaff> hospitalStaffers = new HashSet<>();
	
	
	public HospitalData(Hospital hospital) {
		hospitalId = hospital.getHospitalId();
		hospitalName = hospital.getHospitalName();
		hospitalAddress = hospital.getHospitalAddress();
		hospitalCity = hospital.getHospitalCity();
		hospitalState = hospital.getHospitalState();
		hospitalZip = hospital.getHospitalZip();
		hospitalPhone = hospital.getHospitalPhone();
		
		for(Patient patient: hospital.getPatients()) {
			HospitalPatient hospitalPatient = new HospitalPatient(patient);
			hospitalPatients.add(hospitalPatient);
		}
		
		for(Staff staff: hospital.getStaffers()) {
			HospitalStaff hospitalStaff = new HospitalStaff(staff);
			hospitalStaffers.add(hospitalStaff);
		}
	}


	public HospitalData(Patient patient) {
	}
}
