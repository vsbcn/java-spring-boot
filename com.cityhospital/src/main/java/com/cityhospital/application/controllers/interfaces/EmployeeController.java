package com.cityhospital.application.controllers.interfaces;

import com.cityhospital.application.enums.Status;
import com.cityhospital.application.models.Employee;

import java.util.List;

public interface EmployeeController {
    List<Employee> getAllDoctors();
    Employee findByEmployeeId(Long id);
    Employee findByEmployeeIdPV(Long id);
    List<Employee> findByEmployeeByStatus(Status status);
}
