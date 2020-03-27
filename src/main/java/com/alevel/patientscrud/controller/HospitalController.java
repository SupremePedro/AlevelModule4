package com.alevel.patientscrud.controller;


import com.alevel.patientscrud.model.Patient;
import com.alevel.patientscrud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class HospitalController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public void addPatient(@RequestBody Patient patient){
        patientService.add(patient);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getOne(@PathVariable(value = "id")Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }
    @PutMapping
    public void updatePatient(@RequestBody Patient patient){
        patientService.update(patient);
    }
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient(){
        return new ResponseEntity(patientService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id")Long id){
        patientService.delete(id);
    }
}
