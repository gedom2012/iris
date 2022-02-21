package com.eqs.iris.services;

import com.eqs.iris.entitites.Vacation;
import com.eqs.repositories.VacationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationService {

    @Autowired
    private VacationRepository repository;
    
}
