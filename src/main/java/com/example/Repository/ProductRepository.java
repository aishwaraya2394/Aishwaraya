package com.example.Repository;

import com.example.Entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private static List<Product> products;
    private static Long idCounter;

    public ProductRepository(){
        products = new ArrayList<>();
        idCounter = 0L;
        products.addAll(new DataConfig().loadInitialData());

    }

    /*
     * The four methods defined below are used to fetch data from the Repository(currently the local ArrayList)
     * and to add a new product to the List
     * The products can be fetched based on either name, id or all at once
     * */

    public Long addNewProduct(String name, String category, String description, double price, String imageUrl){

        Long id = null;
        idCounter = products.getLast().getId();
        id = idCounter++;
        products.add(new Product(id,name,category,description,price,imageUrl));

        return id;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getProductsByName(List<String> listOfNames){

        List<Product> productListByName = new ArrayList<>();
        for (String name : listOfNames){

            productListByName.addAll(products.stream().filter(
                    x -> x.getName().equalsIgnoreCase(name)).toList());
        }

        productListByName = productListByName.stream().distinct().collect(Collectors.toList());

        return productListByName;
    }

    public Product getProductById(Long id){
        return products.stream().filter(x -> x.getId().equals(id)).toList().getFirst();
    }

}
