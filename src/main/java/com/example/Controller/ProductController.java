package com.example.Controller;

import com.example.Entity.Product;
import com.example.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    //A properties file defined value to control the edit distance value to restrict the fuzzy search
    @Value("${edit.distance}")
    private String limit;

    private final ProductServiceImpl productService;

    public ProductController(){

        productService = new ProductServiceImpl();
    }

    //Request to handle new Product addition process
    @PostMapping("/products")
    public String addNewProduct(@RequestBody String jsonProduct){

        Long id = productService.addNewProducts(jsonProduct);
        if(!(id == null)){
            return ("Product added successfully with id:"+id);
        }
        return ("Product addition failed");
    }

    //Request to get all Products currently present in Repository
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();

    }

    //Request to search for Products based on Name with relevant details even if it has typos or is incomplete
    @GetMapping("/search")
    public List<Product> getProductsByName(@RequestParam String name){

        return productService.getProductByName(name,Integer.parseInt(limit));

    }

    //Request to get Product based on Id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){

        return productService.getProductById(id);
    }

}