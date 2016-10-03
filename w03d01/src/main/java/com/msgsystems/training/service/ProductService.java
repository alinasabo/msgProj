package com.msgsystems.training.service;

import com.msgsystems.training.model.Product;
import com.msgsystems.training.repository.ProductRepository;

import java.util.ArrayList;


public class ProductService {

    public ProductRepository productRepository=new ProductRepository();

    public ArrayList<Product> getListOfProducts(){

        return productRepository.getListOfProducts();
    }
}
