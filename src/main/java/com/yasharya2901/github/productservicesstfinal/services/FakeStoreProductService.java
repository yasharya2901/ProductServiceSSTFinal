package com.yasharya2901.github.productservicesstfinal.services;

import com.yasharya2901.github.productservicesstfinal.dtos.FakeStoreProductDTO;
import com.yasharya2901.github.productservicesstfinal.models.Category;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{


    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        // convert FakeStoreProductDto object to Product object
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category(fakeStoreProductDto.getId(), fakeStoreProductDto.getTitle(), fakeStoreProductDto.getDescription()));
        product.setImg(fakeStoreProductDto.getImage());
        return product;
    }
}
