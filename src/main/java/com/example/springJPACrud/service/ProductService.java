package com.example.springJPACrud.service;

import com.example.springJPACrud.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> fetchAllProduct();

    Product getProductById(long productId) throws Exception;

     void deleteProductById(long productId) throws Exception;
}
