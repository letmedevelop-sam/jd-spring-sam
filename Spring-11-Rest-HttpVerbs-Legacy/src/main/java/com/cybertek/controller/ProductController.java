package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products/{id}")       //This is creating end point
    public @ResponseBody                        //As default it is GET ->@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("id") long id){
        return  productService.getProduct(id);
    }

    @RequestMapping(value = "/products")
    public @ResponseBody
    List<Product> getProducts(){

        return productService.getProducts();
    }

    //POST
//    @RequestMapping(value = "/products",method = RequestMethod.POST)
//    public @ResponseBody List<Product> createProduct(@RequestBody Product product){
//        return productService.createProduct(product);
//    }
        //DELETE
//    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
//    public @ResponseBody List<Product> deleteProduct(@PathVariable("id") long id){
//        return productService.delete(id);
//    }
        //PUT
//    @RequestMapping(value = "/products/{id}",method = RequestMethod.PUT)
//    public @ResponseBody List<Product> updateProduct(@PathVariable("id") long id,@RequestBody Product product){
//        return productService.updateProduct(id, product);
//    }

}
