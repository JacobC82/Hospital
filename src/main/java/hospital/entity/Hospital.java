package hospital.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import hospital.entity.Patient;
import hospital.entity.Staff;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long hospitalId;
	public String hospitalName;
	public String hospitalAddress;
	public String hospitalCity;
	public String hospitalState;
	public String hospitalZip;
	public String hospitalPhone;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "hospital_patient", joinColumns = @JoinColumn(name = "hospital_id"),
	inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private Set<Patient> patients = new HashSet<Patient>();

	@EqualsAndHashCode.Exclude
	@ToString.Exclude   //changed from petStore to pet_store on line 42- hated that
	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Staff> staffers = new HashSet<Staff>();


}
