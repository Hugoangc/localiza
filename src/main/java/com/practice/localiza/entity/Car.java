package com.practice.localiza.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

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