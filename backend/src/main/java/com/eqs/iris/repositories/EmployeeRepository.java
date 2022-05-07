package com.eqs.iris.repositories;

import com.eqs.iris.entitites.Employee;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long > {
    
}
