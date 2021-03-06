package com.msgsystems.training.Controller;

import com.msgsystems.training.model.Product;
import com.msgsystems.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Lazy
@Controller
public class ProductController {



    private final ProductService productService;
    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/products",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    List<Product> getProducts() {

        return productService.getListOfProducts();
    }
}
