package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller       //We will use @RestController   and remove all   @ResponseBody
@RestController
@RequestMapping("/products") //we defined in application.properties now we need to ad /api to our URI while we test in Postman http://localhost:8080/api/products
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

        //GET           //We replaced @RequestMapping with    @GetMapping
    @GetMapping(value = "/{id}")       //We will not need products "/products/{id}"
                            //As default it is GET ->@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id){
        return  productService.getProduct(id);
    }

    //bring all
    @GetMapping      //We replaced @RequestMapping with    @GetMapping        //we deleted (value = "/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

        //POST          //We replaced @RequestMapping with    @PostMapping
    @PostMapping        // we deleted  (method = RequestMethod.POST)
    public  List<Product> createProduct(@RequestBody Product product){      // we deleted @ResponseBody
        return productService.createProduct(product);
    }
        //DELETE    //We replaced @RequestMapping with    @DeleteMapping
    @DeleteMapping(value = "/{id}")      //we deleted (value = "/products") and ,method = RequestMethod.DELETE
    public List<Product> deleteProduct(@PathVariable("id") long id){        // we deleted @ResponseBody
        return productService.delete(id);
    }
        //PUT            //We replaced @RequestMapping with    @PutMapping
    @PutMapping(value = "/{id}")        //we deleted (value = "/products") and ,method = RequestMethod.PUT
    public  List<Product> updateProduct(@PathVariable("id") long id,@RequestBody Product product){       // we deleted @ResponseBody
        return productService.updateProduct(id, product);
    }

}
