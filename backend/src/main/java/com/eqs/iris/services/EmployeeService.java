package com.eqs.iris.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.eqs.iris.DTO.EmployeeDTO;
import com.eqs.iris.entitites.Employee;
import com.eqs.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) throws Exception {
		try {
			Optional<Employee> obj = repository.findById(id);
			Employee entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
			return new EmployeeDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found " + id);
		}

	}

    
}
