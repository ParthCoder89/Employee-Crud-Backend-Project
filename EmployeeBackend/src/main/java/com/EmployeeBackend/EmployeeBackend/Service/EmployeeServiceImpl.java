package com.EmployeeBackend.EmployeeBackend.Service;

import com.EmployeeBackend.EmployeeBackend.DatabaseData.EmployeeData;
import com.EmployeeBackend.EmployeeBackend.EmployeeDetails.EmployeeDto;
import com.EmployeeBackend.EmployeeBackend.exception.ResourceNotFoundException;
import com.EmployeeBackend.EmployeeBackend.mapper.EmployeeMapper;
import com.EmployeeBackend.EmployeeBackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeData employeeData = EmployeeMapper.mapToEmployeeData(employeeDto);
        EmployeeData savedRepository  = employeeRepository.save(employeeData);
        return EmployeeMapper.mapToEmployeeDto(savedRepository);
    }

    @Override
    public EmployeeDto getEmoloyeeById(Long employeeId) {
        EmployeeData employeeData = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException(("Status Not Found at the given id : " + employeeId)));
        return EmployeeMapper.mapToEmployeeDto(employeeData);
    }

    @Override
    public List<EmployeeDto> getAllAmployee() {
        List<EmployeeData> employeesData = employeeRepository.findAll();
        return employeesData.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        EmployeeData employeeData = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException(("Employee is not found at given id : " + employeeId))
                );
        employeeData.setFirstName(updatedEmployee.getFirstName());
        employeeData.setLastName(updatedEmployee.getLastName());
        employeeData.setEmail(updatedEmployee.getEmail());

        EmployeeData updatedDataInDB = employeeRepository.save(employeeData);
        return EmployeeMapper.mapToEmployeeDto(updatedDataInDB);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        EmployeeData employeeData = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException(("Employee not found at the given index : " + employeeId))
                );
        employeeRepository.deleteById(employeeId);

    }
}
