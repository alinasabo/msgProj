package com.msgsystems.training.Controller;

import com.msgsystems.training.model.Product;
import com.msgsystems.training.model.Store;
import com.msgsystems.training.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    private final StoreService storeService;

   @Autowired
   public StoreController(final StoreService storeService){
        this.storeService=storeService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/stores",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    List<Store> getStores() {

        return storeService.displayStores();
    }
}
