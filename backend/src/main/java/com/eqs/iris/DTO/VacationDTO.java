package com.eqs.iris.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.eqs.iris.entitites.Employee;
import com.eqs.iris.entitites.Vacation;

public class VacationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant date;
    private boolean isChecked;

    public VacationDTO() {
    }

    public VacationDTO(Vacation entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.isChecked = entity.isChecked();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

}
