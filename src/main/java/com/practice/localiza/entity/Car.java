package com.practice.localiza.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String color;
    private Double price;
    private Integer manufactureYear;
    private boolean carStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Brand brand;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="car_owners")
    private List<Owner> owners;

}