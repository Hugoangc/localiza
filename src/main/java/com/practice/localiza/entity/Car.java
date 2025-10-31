package com.practice.localiza.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private Integer price;
    private String brand;
    private Integer manufactureYear;
    private boolean carStatus;

    public Car (){
    }

}