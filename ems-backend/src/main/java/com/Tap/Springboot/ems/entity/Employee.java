package com.Tap.Springboot.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="employee_name")
    private String name;
    @Column(name="employee_email", nullable = true, unique = true)
    private String email;
    @Column(name="employee_phone_no")
    private String phoneNo;
    @Column(name = "employee_department")
    private String  department;


}
