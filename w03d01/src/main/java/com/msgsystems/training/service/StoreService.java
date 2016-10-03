package com.msgsystems.training.service;


import com.msgsystems.training.model.Product;
import com.msgsystems.training.model.Store;
import com.msgsystems.training.repository.StoreRepository;

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
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(final StoreRepository storeRepository){

        this.storeRepository=storeRepository;
    }


    public void displayStores()
    {
        storeRepository.displayStores();
    }

}
