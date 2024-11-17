package com.example.Controller;

import com.example.Entity.Product;
import com.example.Service.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(){

        productService = new ProductServiceImpl();
    }

    @PostMapping("/products")
    public String addNewProduct(@RequestBody String jsonProduct){

        Long id = productService.addNewProducts(jsonProduct);
        if(!(id == null)){
            return ("Product added successfully with id:"+id);
        }
        return ("Product addition failed");
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){

        List<Product>products = productService.getAllProducts();
        int start = page * size;
        int end = Math.min(start + size , products.size());

        return products.subList(start, end);

    }

    @GetMapping("/search")
    public List<Product> getProductsByName(@RequestParam String name){

        return productService.getProductByName(name);

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){

        return productService.getProductById(id);
    }

}