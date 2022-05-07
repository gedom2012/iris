package com.eqs.iris.controllers;

import com.eqs.iris.DTO.EmployeeDTO;
import com.eqs.iris.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) throws Exception {
		EmployeeDTO ProductDTO = service.findById(id);
		return ResponseEntity.ok().body(ProductDTO);
	}
    
}
