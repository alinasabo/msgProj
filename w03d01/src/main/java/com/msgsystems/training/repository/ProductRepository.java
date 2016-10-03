package com.msgsystems.training.repository;

import com.msgsystems.training.model.Product;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

public class ProductRepository {

    ArrayList<Product> productList = new ArrayList<>();
    public ArrayList<Product> getListOfProducts(){


        try (Stream<String> lines = Files.lines(Paths.get("products.csv"))) {

            Function<String[], ArrayList<Product>> function = value -> {
                String[] lineStr = value;
                Product product = new Product(Integer.parseInt(lineStr[0]), lineStr[1], Double.parseDouble(lineStr[3]), lineStr[2]);
                productList.add(product);
                return productList;
            };

            lines.forEach(l ->
                    function.apply(l.split(",")));

            //  productList.forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return productList;
    }
}
