package com.example.Repository;

import com.example.Entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private static List<Product> products;
    private static Long idCounter;

    ProductRepository(){
        products = new ArrayList<>();
        idCounter = 0L;

    }
}
