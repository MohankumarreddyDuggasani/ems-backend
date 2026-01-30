package com.Tap.Springboot.ems.service.impl;

import com.Tap.Springboot.ems.dto.EmployeeDto;
import com.Tap.Springboot.ems.entity.Employee;
import com.Tap.Springboot.ems.exception.ResourceNotFoundException;
import com.Tap.Springboot.ems.mapper.EmployeeMapper;
import com.Tap.Springboot.ems.repoistary.EmployeeRepositary;
import com.Tap.Springboot.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepositary employeeRepositary;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
       Employee employee = EmployeeMapper.employeeDtoMapToEmployee(employeeDto);
       Employee savedEmployee=employeeRepositary.save(employee);
        return EmployeeMapper.employeeMapToDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepositary.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee is not Exist with given Id:"+employeeId));
        return EmployeeMapper.employeeMapToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

       List<Employee> employees= employeeRepositary.findAll();

        return employees.stream().map((employee)->EmployeeMapper.employeeMapToDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepositary.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee id is not found:"+ employeeId));
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setPhoneNo(updatedEmployee.getPhoneNo());

        Employee updatedEmploye=employeeRepositary.save(employee);

        return EmployeeMapper.employeeMapToDto(updatedEmploye);
    }

    @Override
    public void deleteById(Long employeeId) {
        Employee employee=employeeRepositary.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee is not Exist with given Id:"+employeeId));

        employeeRepositary.deleteById(employeeId);


    }

    @Override
    public void deleteAllEmployees() {
        employeeRepositary.deleteAll();
    }
}
