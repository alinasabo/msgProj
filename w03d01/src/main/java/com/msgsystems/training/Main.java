package com.msgsystems.training;

import com.msgsystems.training.model.Store;
import com.msgsystems.training.service.StoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        final StoreService storeService=applicationContext.getBean(StoreService.class);

        storeService.displayStores();

      /*  StoreService storeService = new StoreService();

        storeService.displayStores();
        storeService.filterStoresToDisplay();

        storeService.displayTotalCostsOfStores();

        storeService.removeStoreByName("Alina");
        storeService.removeStoreByName("ZARA");
        storeService.writeInAFile();*/




    }
}
