package com.example.springJPACrud.controller;

import com.example.springJPACrud.model.Product;
import com.example.springJPACrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //To find all the products in our DB
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.fetchAllProduct());
    }

    //To find product based on it's id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) throws Exception{
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(productService.createProduct(product));
    }

    //To delete a product based on it's id
    @DeleteMapping("/delProduct/{id}")
    public String deleteProduct(@PathVariable long id ) throws Exception{
        productService.deleteProductById(id);
        return "Data Deleted";
    }
}
