package com.Tap.Springboot.ems.repoistary;

import com.Tap.Springboot.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositary extends JpaRepository<Employee, Long> {
}
