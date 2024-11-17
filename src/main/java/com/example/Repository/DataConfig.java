package com.example.Repository;

import com.example.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class DataConfig {

    private List<Product> products = new ArrayList<>();

    public List<Product> ladInitialData(){

        products.add(new Product(1L,"Table1","Table","Study Table",129.99D,"https://www.pexels.com/photo/wireless-laptop-with-mouse-on-desk-27467772/"));
        products.add(new Product(2L,"Table2","Table","Study Table",155.99D,"https://www.pexels.com/photo/computer-on-a-wooden-desk-with-the-designer-s-business-website-on-the-screen-7181188/"));
        products.add(new Product(3L,"Table3","Table","Dining Table",1224.99D,"https://www.pexels.com/photo/white-ceramic-vase-on-dining-table-271696/"));
        products.add(new Product(4L,"Table4","Table","Dining Table",1789.99D,"https://www.pexels.com/photo/rectangular-brown-wooden-dining-table-and-chairs-set-2092058/"));
        products.add(new Product(5L,"Wardrobe1","Wardrobe","Wardrobe Wooden",1999.99D,"https://www.pexels.com/photo/modern-bedroom-interior-15199381/"));
        products.add(new Product(6L,"Wardrobe2","Wardrobe","Wardrobe with Mirrors",2129.99D,"https://www.pexels.com/photo/view-of-a-bedroom-12700461/"));
        products.add(new Product(7L,"Bed1","Bed","Queen size Bed ",2534.99D,"https://www.pexels.com/photo/view-of-a-bedroom-12700461/"));
        products.add(new Product(8L,"Bed2","Bed","Queen size Bed ",3154.99D,"https://www.pexels.com/photo/modern-bedroom-interior-8089260"));
        products.add(new Product(9L,"Bed3","Bed","Queen size Bed ",1934.99D,"https://www.pexels.com/photo/photo-of-bed-near-wooden-cabinet-3935331/"));
        products.add(new Product(10L,"Bed4","Bed","Single Bed",1354.99D,"https://www.pexels.com/photo/a-single-bed-with-throw-pillows-6114341/"));
        products.add(new Product(11L,"Bed5","Bed","Single Bed",1134.99D,"https://www.pexels.com/photo/single-bed-in-room-9899861/"));
        products.add(new Product(12L,"Bed6","Bed","Single Bed",1454.99D,"https://www.pexels.com/photo/light-bedroom-with-cushions-on-bed-4993065/"));

        return products;
    }

}
