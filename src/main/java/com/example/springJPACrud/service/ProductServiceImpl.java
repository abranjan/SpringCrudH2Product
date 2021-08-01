package com.example.springJPACrud.service;

import com.example.springJPACrud.model.Product;
import com.example.springJPACrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) throws Exception{
        Optional<Product> productById = this.productRepository.findById(productId);

        if(productById.isPresent()){
            return productById.get();
        }else{
            throw new Exception("Record Not Found!!!"+ productById);
        }
    }

    @Override
    public void deleteProductById(long productId) throws Exception{
        try{
            this.productRepository.deleteById(productId);
        }catch(Exception ex){
            throw new Exception("Id is not present. Please validate: "+ productId);
        }
    }
}
