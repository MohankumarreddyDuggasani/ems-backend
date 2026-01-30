package com.Tap.Springboot.ems.controller;

import com.Tap.Springboot.ems.dto.EmployeeDto;
import com.Tap.Springboot.ems.service.EmployeeService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
// build add employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get employee rest api
    @GetMapping("{employeeId}")
    public  ResponseEntity<EmployeeDto> getEmployeById(@PathVariable Long employeeId){
      EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
@GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos=employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos);
    }
@PutMapping("{employeeId}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable  Long employeeId, @RequestBody EmployeeDto updateEmployee){
        EmployeeDto updatedEmployee=employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }
@DeleteMapping("{employeeId}")
    public  ResponseEntity<String> deleteById(@PathVariable Long employeeId){
        employeeService.deleteById(employeeId);
        return ResponseEntity.ok("Employee is Successfully deleted");

    }
    @DeleteMapping("/all")
    public  ResponseEntity<String> deleteAllEmployees(){
        employeeService.deleteAllEmployees();
        return  ResponseEntity.ok("All employees are deleted:");
    }




}
