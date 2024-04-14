package com.yasharya2901.github.productservicesstfinal.models;


import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    @ManyToOne
    private Category category;
    private String img;

}
