package com.yasharya2901.github.productservicesstfinal.services;

import com.yasharya2901.github.productservicesstfinal.dtos.FakeStoreProductDTO;
import com.yasharya2901.github.productservicesstfinal.exceptions.ProductNotFoundException;
import com.yasharya2901.github.productservicesstfinal.models.Category;
import com.yasharya2901.github.productservicesstfinal.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{


    @Override
    public Product getProductById(Long id){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Product with " + id + " doesn't exist");
        }
        // convert FakeStoreProductDto object to Product object
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO[] fakeStoreProductDTOs = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
//        ResponseEntity<List<FakeStoreProductDTO>> response = restTemplate.exchange(
//                "https://fakestoreapi.com/products",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<FakeStoreProductDTO>>() {}
//        );
//        List<FakeStoreProductDTO> fakeStoreProductDTOs = response.getBody();
        if (fakeStoreProductDTOs == null) {
            return null;
        }

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDto: fakeStoreProductDTOs) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDTO fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
//        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setImg(fakeStoreProductDto.getImage());
        return product;
    }
}
