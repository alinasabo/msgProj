package com.msgsystems.training.repository;

import com.msgsystems.training.model.Product;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;
@Repository
public class ProductRepository {

    ArrayList<Product> productList ;
    public ArrayList<Product> getListOfProducts(){
        productList = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\saboa\\Desktop\\products.csv"))) {

            Function<String[], ArrayList<Product>> function = value -> {
                String[] lineStr = value;
                Product product = new Product(Integer.parseInt(lineStr[0]), lineStr[1], Double.parseDouble(lineStr[3]), lineStr[2]);
                productList.add(product);
            //    productList.forEach(System.out::println);
                return productList;
            };

            lines.forEach(l ->
                    function.apply(l.split(",")));
         } catch (Exception ex) {
            ex.printStackTrace();
        }

        return productList;
    }
}
