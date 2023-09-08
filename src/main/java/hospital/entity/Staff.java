package hospital.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
//import hospital.entity.Hospital;

@Entity
@Data
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	private String staffJobTitle;
	private String staffFirstName;
	private String staffLastName;
	private String staffPhone;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
}

