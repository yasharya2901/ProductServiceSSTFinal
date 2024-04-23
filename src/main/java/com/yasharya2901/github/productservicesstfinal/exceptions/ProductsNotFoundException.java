package com.yasharya2901.github.productservicesstfinal.exceptions;

public class ProductsNotFoundException extends RuntimeException{
    public ProductsNotFoundException(String message){
        super(message);
    }
}
