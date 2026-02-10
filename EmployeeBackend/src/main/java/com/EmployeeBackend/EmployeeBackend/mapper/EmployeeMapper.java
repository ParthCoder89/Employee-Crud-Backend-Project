package com.EmployeeBackend.EmployeeBackend.mapper;

import com.EmployeeBackend.EmployeeBackend.DatabaseData.EmployeeData;
import com.EmployeeBackend.EmployeeBackend.EmployeeDetails.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(EmployeeData employeeData){
        return new EmployeeDto(
                employeeData.getId(),
                employeeData.getFirstName(),
                employeeData.getLastName(),
                employeeData.getEmail()
        );
    }
    public static EmployeeData mapToEmployeeData(EmployeeDto employeeDto){
        return new EmployeeData(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}
