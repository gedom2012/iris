package com.eqs.iris.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.eqs.iris.DTO.EmployeeDTO;
import com.eqs.iris.DTO.VacationDTO;
import com.eqs.iris.entitites.Employee;
import com.eqs.iris.entitites.Vacation;
import com.eqs.iris.repositories.EmployeeRepository;
import com.eqs.iris.repositories.VacationRepository;
import com.eqs.iris.services.exceptions.DataBaseException;
import com.eqs.iris.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private VacationRepository vacationRepository;

	@Transactional(readOnly = true)
	public Page<EmployeeDTO> findAll(Pageable pageable) {
		Page<Employee> list = repository.findAll(pageable);
		return list.map(x -> new EmployeeDTO(x));
	}

	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) throws Exception {
		try {
			Optional<Employee> obj = repository.findById(id);
			Employee entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
			return new EmployeeDTO(entity, entity.getVacations());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}

	}

	@Transactional
	public EmployeeDTO insert(EmployeeDTO employeeDTO) {
		Employee entity = new Employee();
		copyDtoToEntity(employeeDTO, entity);
		entity = repository.save(entity);
		return new EmployeeDTO(entity, entity.getVacations());

	}

	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		try {
			Employee entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EmployeeDTO(entity, entity.getVacations());
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity Violation");
		}
	}

	private void copyDtoToEntity(EmployeeDTO dto, Employee entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setBirthDate(dto.getBirthDate());
		entity.setAdmissionDate(dto.getAdmissionDate());
		entity.setTotalVacationDays(dto.getTotalVacationDays());

		entity.getVacations().clear();
		for (VacationDTO vacationDTO : dto.getVacations()) {
			Vacation vacation = vacationRepository.getOne(vacationDTO.getId());
			entity.getVacations().add(vacation);
		}

	}

}
