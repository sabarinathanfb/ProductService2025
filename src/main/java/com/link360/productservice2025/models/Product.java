package com.link360.productservice2025.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {

    private String title;
    private double price;
    private String description;
    private Category category;
    private String imageUrl;

}
