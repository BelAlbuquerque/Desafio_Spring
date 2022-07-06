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

}
