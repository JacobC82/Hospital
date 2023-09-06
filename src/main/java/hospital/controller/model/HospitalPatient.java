package hospital.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.entity.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HospitalPatient {
	private Long patientId;
	private String patientFirstName;
	private String patientLastName;
	private String patientPhone;
	private String complaint;
	private String diagnosis;
	
	//private Set<HospitalPatient> hospitalPatients = new HashSet<>();
	
	public HospitalPatient(Patient patient){
		patientId = patient.getPatientId();
		patientFirstName = patient.getPatientFirstName();
		patientLastName = patient.getPatientLastName();
		patientPhone = patient.getPatientPhone();
		complaint = patient.getComplaint();
		diagnosis = patient.getDiagnosis();
		
	}
	
}
