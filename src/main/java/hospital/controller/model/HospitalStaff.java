package hospital.controller.model;

import java.util.HashSet;
import java.util.Set;

import hospital.entity.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class HospitalStaff {
	private Long staffId;
	private String staffFirstName;
	private String staffLastName;
	private String staffPhone;
	private String staffJobTitle;
	
	public HospitalStaff(Staff staff) {
		staffId = staff.getStaffId();
		staffFirstName = staff.getStaffFirstName();
		staffLastName = staff.getStaffLastName();
		staffPhone = staff.getStaffPhone();
		staffJobTitle = staff.getStaffJobTitle();
	}
}
