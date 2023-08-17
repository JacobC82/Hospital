package hospital.controller.model;

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
	
	public HospitalPatient(Patient patient){
		patientId = patient.getPatientId();
		patientFirstName = patient.getPatientFirstName();
		patientLastName = patient.getPatientLastName();
		patientPhone = patient.getPatientPhone();
		
	}
}
