package com.yasharya2901.github.productservicesstfinal.dtos;


import com.yasharya2901.github.productservicesstfinal.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
