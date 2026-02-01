package com.EmployeeBackend.EmployeeBackend.Service;

import com.EmployeeBackend.EmployeeBackend.EmployeeDetails.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmoloyeeById (Long employeeId);

    List<EmployeeDto> getAllAmployee();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void  deleteEmployee(Long employeeId);
}
