package com.msgsystems.training.repository;

import com.msgsystems.training.model.Product;
import com.msgsystems.training.model.Store;
import com.msgsystems.training.service.ProductService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



public class StoreRepository {

    String[] str;
    String line;

    ArrayList<Product> productList = new ArrayList<>();
    ArrayList<Store> storeList = new ArrayList<>();
    ProductService productService=new ProductService();

    public void displayStores() {

        productList=productService.getListOfProducts();


        try (FileReader fileReader = new FileReader("stores.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (Optional.ofNullable(line = bufferedReader.readLine()).isPresent()) {
                List<Product> tempProducts;
                str = line.split(",");
                List<String> el = Arrays.asList(str[4].split(" "));

                //  el.forEach(System.out::println);

                tempProducts = productList.stream()
                                          .filter(item -> el.contains(String.valueOf(item.getId())))
                                          .collect(Collectors.toList());

                //tempProducts.forEach(System.out::println);
                Store store = new Store(Integer.parseInt(str[0]), str[1], str[2], str[3], (ArrayList) tempProducts);
                storeList.add(store);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Print the list of stores
        System.out.println("List of stores: ");
        storeList.forEach(System.out::println);


    }

    public void filterStoresToDisplay() {
        //Filter stores  by floor

        System.out.println("\nStores filltered: ");
        storeList.stream()
                 .filter(item -> item.getFloor() > 2)
                 .forEach(System.out::println);
    }

    public  void displayTotalCostsOfStores(){
        //Calculate the total sum of the products file
        double sum = productList.stream()
                                .mapToDouble(it -> it.getPrice())
                                .sum();
        System.out.println("\nTotal costs from products file: " + sum);

        //Display the total sum of each store
        System.out.println("\nTotal costs for each store: ");
        storeList.stream()
                 .map(item -> item.getProductsList().stream()
                                  .mapToDouble(it -> it.getPrice())
                                  .sum())
                 .forEach(System.out::println);
    }
    public void addStore(Store store) {
        storeList.add(store);

        System.out.print("Add Store\n id: ");

    }

    public void writeInAFile(){

        try (FileWriter writer = new FileWriter("output.txt")) {

            storeList.forEach(st->writeToFile(writer, st.getName()));
            // writer.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void removeStoreByName(String name) {
        System.out.println();

        storeList.removeIf(st->st.getName().equals(name));
        storeList.forEach(System.out::println);

    }

    private void writeToFile(FileWriter fw, String p) {
        try {
            fw.write(String.format("%s%n", p));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
