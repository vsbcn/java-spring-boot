package com.cityhospital.application.controllers.impl;

import com.cityhospital.application.controllers.interfaces.PatientController;
import com.cityhospital.application.enums.Status;
import com.cityhospital.application.models.Patient;
import com.cityhospital.application.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientControllerImpl implements PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient-by-id")
    public Patient findPatientByPatientId(@RequestParam Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.isPresent() ? patientOptional.get() : null;
    }

    @GetMapping("/patient/{id}")
    public Patient findPatientByPatientIdPV(@PathVariable(name = "id") Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.isPresent() ? patientOptional.get() : null;
    }

    @GetMapping("/patients-by-dob")
    public List<Patient> findPatientsByBirth(@RequestParam String min,@RequestParam String max) {

        LocalDate minDate = LocalDate.parse(min);
        LocalDate maxDate = LocalDate.parse(max);

        return patientRepository.findPatientsByBirth(minDate, maxDate);
    }

    @GetMapping("/patients-by-doctor-department")
    public List<Patient> findPatientsByAdmittingDoctorDepartment(@RequestParam String department) {
        return patientRepository.findPatientsByAdmittingDoctorDepartment(department);
    }

    @GetMapping("/patients-by-doctor-status")
    public List<Patient> findPatientsByAdmittingDoctorStatus(Status status) {
        return patientRepository.findPatientsByAdmittingDoctorStatus(status);
    }
}
