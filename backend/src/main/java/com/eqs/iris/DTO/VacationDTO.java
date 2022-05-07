package com.eqs.iris.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.eqs.iris.entitites.Employee;
import com.eqs.iris.entitites.Vacation;

public class VacationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant startDate;
    private Instant endDate;
    private Employee employee;

    public VacationDTO(Long id, Instant startDate, Instant endDate, Employee employee) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public VacationDTO(Vacation entity){
        this.id = entity.getId();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.employee = entity.getEmployee();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

 

    

}
