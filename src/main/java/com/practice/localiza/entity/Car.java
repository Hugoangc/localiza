package com.practice.localiza.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private Double price;
    private String brand;
    private Integer manufactureYear;
    private boolean carStatus;

//    public Car (){
//    }

//    public Car(String name, String color, Double price, String brand, Integer manufactureYear, boolean carStatus) {
//        this.name = name;
//        this.color = color;
//        this.price = price;
//        this.brand = brand;
//        this.manufactureYear = manufactureYear;
//        this.carStatus = carStatus;
//    }

}