package hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hospital.entity.Staff;

public interface StaffDao extends JpaRepository<Staff, Long> {

}
