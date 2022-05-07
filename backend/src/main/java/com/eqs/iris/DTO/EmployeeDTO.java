package com.eqs.iris.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.eqs.iris.entitites.Employee;

public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private int totalVacationDays;
    private Instant birthDate;
    private Instant admissionDate;
    private String email;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Employee entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.totalVacationDays = entity.getTotalVacationDays();
        this.birthDate = entity.getBirthDate();
        this.admissionDate = entity.getAdmissionDate();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    public void setTotalVacationDays(int totalVacationDays) {
        this.totalVacationDays = totalVacationDays;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Instant getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Instant admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
