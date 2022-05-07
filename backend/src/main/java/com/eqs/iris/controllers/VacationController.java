package com.eqs.iris.controllers;

import com.eqs.iris.DTO.EmployeeDTO;
import com.eqs.iris.DTO.VacationDTO;
import com.eqs.iris.services.VacationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vacations")
public class VacationController {

    @Autowired
    private VacationService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<VacationDTO> findById(@PathVariable Long id) throws Exception {
        VacationDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    
}
