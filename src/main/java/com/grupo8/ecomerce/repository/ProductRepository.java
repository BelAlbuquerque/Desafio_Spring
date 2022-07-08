package com.grupo8.ecomerce.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.grupo8.ecomerce.model.Product;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private final String pathProduct = "src/main/resources/product.json";

    public void createProduct(Product newProduct){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Product> listProduct = null;

        try{
            listProduct = Arrays.asList(mapper.readValue(new File(pathProduct), Product[].class));
            List<Product> copyListProduct = new ArrayList<>(listProduct);
            copyListProduct.add(newProduct);
            writer.writeValue(new File(pathProduct), copyListProduct);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Product> getAllProducts() {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productList = null;

        try {
            productList = Arrays.asList(mapper.readValue(new File(pathProduct), Product[].class));
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
        return  productList;
    }

    public void updateProducts(List<Product> updatedProductList) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try{
            writer.writeValue(new File(pathProduct), updatedProductList);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
