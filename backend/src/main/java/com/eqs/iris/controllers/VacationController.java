package com.eqs.iris.controllers;

import com.eqs.iris.services.VacationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vacations")
public class VacationController {

    @Autowired
    private VacationService service;
    
}
