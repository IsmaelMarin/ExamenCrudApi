package com.examen.e_commerce.model;

import jakarta.persistence.*;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    public enum CategoryType {
        ELECTRONICA, MODA, COMESTIBLES, HOGAR, JUGUETES, DIGITAL_SERVICE
    }

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}
