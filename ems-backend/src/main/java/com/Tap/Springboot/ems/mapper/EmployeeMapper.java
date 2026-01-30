package com.Tap.Springboot.ems.mapper;

import com.Tap.Springboot.ems.dto.EmployeeDto;
import com.Tap.Springboot.ems.entity.Employee;

public class EmployeeMapper {
    public  static EmployeeDto employeeMapToDto(Employee employee){
     return  new EmployeeDto(  employee.getId(),employee.getName(),employee.getEmail(),employee.getPhoneNo(),employee.getDepartment());

    }


    public  static  Employee employeeDtoMapToEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getEmail(), employeeDto.getPhoneNo(), employeeDto.getDepartment());
    }


}
