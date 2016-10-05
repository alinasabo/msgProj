package com.msgsystems.training.service;

import com.msgsystems.training.model.Product;
import com.msgsystems.training.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public ProductRepository productRepository=new ProductRepository();
    @Autowired
    public ArrayList<Product> getListOfProducts(){

        return productRepository.getListOfProducts();
    }

}
