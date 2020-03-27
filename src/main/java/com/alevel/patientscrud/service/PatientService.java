package com.alevel.patientscrud.service;

import com.alevel.patientscrud.dao.PatientDao;
import com.alevel.patientscrud.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    public void add(Patient patient) {
        patientDao.save(patient);
    }
    public void update(Patient patient) {
        patientDao.update(patient);
    }

    public Patient findById(Long id){
        return patientDao.findById(id);
    }

    public List<Patient> findAll(){
        return patientDao.findAll();
    }

    public void delete(Long id){
        patientDao.delete(id);
    }

}
