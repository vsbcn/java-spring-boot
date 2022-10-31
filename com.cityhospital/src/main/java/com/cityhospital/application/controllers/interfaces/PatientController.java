package com.cityhospital.application.controllers.interfaces;

import com.cityhospital.application.enums.Status;
import com.cityhospital.application.models.Patient;

import java.util.List;

public interface PatientController {
    Patient findPatientByPatientId(Integer id);
    Patient findPatientByPatientIdPV(Integer id);
    List<Patient> findPatientsByBirth(String min, String max);

    List<Patient> findPatientsByAdmittingDoctorDepartment(String department);

    List<Patient> findPatientsByAdmittingDoctorStatus(Status status);

}
