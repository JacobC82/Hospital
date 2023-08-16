package hospital.entity;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hospitalId;
	
}
