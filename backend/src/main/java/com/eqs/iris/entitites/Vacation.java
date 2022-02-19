package com.eqs.iris.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb.vacation")
public class Vacation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalDays;
   // @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    //Set<Instant> dates = new HashSet<>();

    @OneToOne(mappedBy = "vacation")
    private Employee employee;
}
