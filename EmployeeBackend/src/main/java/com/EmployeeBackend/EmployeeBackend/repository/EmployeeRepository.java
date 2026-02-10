package com.EmployeeBackend.EmployeeBackend.repository;

import com.EmployeeBackend.EmployeeBackend.DatabaseData.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<EmployeeData, Long> {
}
