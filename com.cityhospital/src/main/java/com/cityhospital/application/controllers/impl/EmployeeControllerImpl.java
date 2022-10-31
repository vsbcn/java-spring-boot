package com.cityhospital.application.controllers.impl;

import com.cityhospital.application.controllers.interfaces.EmployeeController;
import com.cityhospital.application.enums.Status;
import com.cityhospital.application.models.Employee;
import com.cityhospital.application.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/doctors")
    public List<Employee> getAllDoctors() {
        return employeeRepository.getAllDoctors();
    }

    @GetMapping("/doctor-by-id")
    public Employee findByEmployeeId(@RequestParam Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findByDoctorId(id);
        return employeeOptional.isPresent() ? employeeOptional.get() : null;
    }

    @GetMapping("/doctor/{id}")
    public Employee findByEmployeeIdPV(@PathVariable(name = "id")Long id){
        Optional<Employee> employeeOptional = employeeRepository.findByDoctorId(156545l);
        return employeeOptional.isPresent() ? employeeOptional.get() : null;

    }

    @GetMapping("/doctors-by-status")
    public List<Employee> findByEmployeeByStatus(@RequestParam Status status) {
        return employeeRepository.findByDoctorStatus(status);
    }
}
