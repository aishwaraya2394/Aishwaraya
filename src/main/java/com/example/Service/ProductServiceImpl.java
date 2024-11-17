package com.example.Service;

import com.example.Entity.Product;
import com.example.Repository.ProductRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService{


    private static final Logger logger = Logger.getLogger("ProductServiceImpl.class");

    private static final ProductRepository productRepository = new ProductRepository();


    /*
     * The four methods defined below are used to fetch data from the Repository
     * and add a new product to the List
     * The products can be fetched based on either name, id or all at once
     * */


    //Parse the json string into individual variables for creating new Product
    @Override
    public Long addNewProducts(String json) {

        Long id = null;
        JSONParser jsonParser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
            String name = jsonObject.get("name").toString();
            String category = jsonObject.get("category").toString();
            String description = jsonObject.get("description").toString();
            double price = Double.parseDouble(jsonObject.get("price").toString());
            String imageUrl = jsonObject.get("imageUrl").toString();

            id = productRepository.addNewProduct(name,category,description, price, imageUrl);

        }
        catch (ParseException e){
            logger.log(Level.INFO,"Error while parsing the json string containing the new product details"+e.toString());
        }
        return id;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    //Based on the similarity to user provided name, Products with relevant names are returned
    @Override
    public List<Product> getProductByName(String name, int limit) {

        FuzzySearchImplementation fuzzy = new FuzzySearchImplementation();
        List<String> productsByName = new ArrayList<>();

        for(Product product : getAllProducts()){

            if(fuzzy.fuzzyMatch(name, product.getName(),limit)){
                productsByName.add(product.getName());
            }
        }

        return productRepository.getProductsByName(productsByName);
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.getProductById(id);
    }
}
