package com.eqs.iris.entitites;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb.employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant birthDate;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant admissionDate;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vacation_id", referencedColumnName = "id")
    private Vacation vacation;

}

