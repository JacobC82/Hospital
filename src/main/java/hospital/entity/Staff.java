package hospital.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import hospital.entity.Hospital;

@Entity
@Data
public class Staff {
	
	private Long staffId;
	private String staffJobTitle;
	private String staffFirstName;
	private String staffLastName;
	private Long staffPhone;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;
}

