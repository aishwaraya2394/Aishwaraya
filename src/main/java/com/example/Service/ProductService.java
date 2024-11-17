package com.example.Service;

import com.example.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public Long addNewProducts(String json);

    public List<Product> getAllProducts();

    public List<Product> getProductByName(String name, int limit);

    public Product getProductById(Long id);

}
