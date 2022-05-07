package com.eqs.iris.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.eqs.iris.DTO.VacationDTO;
import com.eqs.iris.entitites.Vacation;
import com.eqs.iris.repositories.VacationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VacationService {

    @Autowired
    private VacationRepository repository;

    @Transactional(readOnly = true)
	public VacationDTO findById(Long id) throws Exception {
		try {
			Optional<Vacation> obj = repository.findById(id);
			Vacation entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
			return new VacationDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found " + id);
		}

	}
    
}
