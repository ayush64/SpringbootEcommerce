package com.ayush.ecommerce.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "states")
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
