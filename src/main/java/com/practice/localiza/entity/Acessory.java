package com.practice.localiza.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@NotBlank(message = "Nome do acessório é obrigatório")
    @NotNull
    private String name;
    private String description;

}