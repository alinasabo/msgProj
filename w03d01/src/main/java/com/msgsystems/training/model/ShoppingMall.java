package com.msgsystems.training.model;

import java.util.List;


public class ShoppingMall {

    private String name;
    List<Store> stores;

    public ShoppingMall(List<Store> stores) {
        this.stores = stores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
