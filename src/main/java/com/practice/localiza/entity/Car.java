package com.practice.localiza.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

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
    @NotNull
    private String name;
    private String color;
    private Double price;
    private Integer manufactureYear;
    private boolean carStatus;

    @ManyToOne //(cascade = CascadeType.ALL)
    private Brand brand;

    @ManyToMany
    @JoinTable(name = "car_acessory")
    private List<Acessory> acessories;


}