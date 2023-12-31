package hospital.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	private String patientFirstName;
	private String patientLastName;
	private String patientPhone;
	private String complaint;
	private String diagnosis;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany()
	@JoinTable(name = "hospital_patient", joinColumns = @JoinColumn
	(name = "patient_id"),
	inverseJoinColumns = @JoinColumn(name = "hospital_id"))
	Set<Hospital> hospitals = new HashSet<>();
}
//Making changes to ensure save