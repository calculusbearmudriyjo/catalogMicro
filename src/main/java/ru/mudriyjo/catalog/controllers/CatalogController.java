package ru.mudriyjo.catalog.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mudriyjo.catalog.entity.Product;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/catalog")
public class CatalogController {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1,"test"));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts(HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
        response.setStatus(200);
        return products;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteProduct(HttpServletResponse response) throws IOException {
        products.clear();
        response.setStatus(200);
    }
}
