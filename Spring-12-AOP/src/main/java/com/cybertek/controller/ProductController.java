package com.cybertek.controller;

import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller       //We will use @RestController   and remove all   @ResponseBody
@RestController
@RequestMapping("/products") //    test in Postman http://localhost:8080/products
public class ProductController {


    //MAIN IDEA IS ABSTRACTION IN CONTROLLER CLASS
    //WE DONT WANT TO WRITE SO MUCH BUSINESS LOGIC IN THE CONTROLLER CLASS
    //Thats why we create service / service impl / repository

    //FOR LOGGER WE WILL USE AOP - Aspect Oriented Programming
    //We move all logger lines to other class and we call them where we need
    //cross cutting :
    //Aspect : it is NOT a bean. It allows us before / after do smt
    //Aspect is not controller
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

                //WE MOVED the below line TO aspects package
    //Logger logger = LoggerFactory.getLogger(ProductController.class);



        //GET           //We replaced @RequestMapping with    @GetMapping
        //bring certain product  and add headers
//    @GetMapping(value = "/{id}")       //We will not need products "/products/{id}"
                            //As default it is GET ->@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
//    public ResponseEntity <Product> getProduct(@PathVariable("id") long id){
//        return  ResponseEntity
//                .ok(productService.getProduct(id));
//    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts(){
        //WE MOVED the below line TO aspects package
      //  logger.info("Before -> Controller:{} - Method:{} - Input Parameter :{}", "ProductController", "getProducts()");

            List<Product> list = productService.getProducts();
        //WE MOVED the below line TO aspects package
      //  logger.info("After -> Controller:{} - Method:{} - Output Parameters : {}", "ProductController", "getProducts", list);

        return list;
    }


    //create product
        //POST          //We replaced @RequestMapping with    @PostMapping
//    @PostMapping        // we deleted  (method = RequestMethod.POST)
//    public  ResponseEntity<List<Product>> createProduct(@RequestBody Product product){      // we deleted @ResponseBody
//
//        List<Product> set = productService.createProduct(product);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .header("Version", "Cybertek.v1")
//                .header("Operation", "Create")
//                .body(set);
//    }

    @PostMapping        // we changed this part for day45 36th minute
    public  List<Product> createProduct(@RequestBody Product product){
        List<Product> set = productService.createProduct(product);
        return set;
    }


        //DELETE    //We replaced @RequestMapping with    @DeleteMapping
    @DeleteMapping(value = "/{id}")      //we deleted (value = "/products") and ,method = RequestMethod.DELETE
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") long id){        // we deleted @ResponseBody

        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "Cybertek.v1");
        responseHttpHeaders.set("Operation", "Delete");

        List<Product> list = productService.delete(id);

        return new ResponseEntity<>(list, responseHttpHeaders, HttpStatus.OK);
    }



        //PUT            //We replaced @RequestMapping with    @PutMapping
    @PutMapping(value = "/{id}")        //we deleted (value = "/products") and ,method = RequestMethod.PUT
    public  ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id,@RequestBody Product product){       // we deleted @ResponseBody

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "Cybertek.v1");
        map.add("Operation", "Update");

        List<Product> list = productService.updateProduct(id, product);

        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }



    @GetMapping("/read")        //test GET  from -> Postman http://localhost:8080/api/products/read
    public ResponseEntity<ResponseWrapper> readAllProducts(){
        return ResponseEntity
                .ok(new ResponseWrapper("Products Successfully Retrieved", productService.getProducts()));
    }

    /*
    {
    "success": true,
    "message": "Products Successfully Retrieved",
    "code": 200,
    "data": [
        {
            "id": 1,
            "name": "DELL"
        },
        {
            "id": 2,
            "name": "MACBOOK"
        },
        {
            "id": 3,
            "name": "Iphone"
        },
        {
            "id": 4,
            "name": "IPAD"
        }
    ]
}
     */


    @DeleteMapping("/delete/{id}")        //test DELETE  from -> Postman http://localhost:8080/api/products/delete/1
    public ResponseEntity<ResponseWrapper> deleteProductMessage(@PathVariable("id") long id){
        return ResponseEntity
                .ok(new ResponseWrapper("Products Successfully Deleted"));
    }
    /*
    {
    "success": true,
    "message": "Products Successfully Deleted",
    "code": 200,
    "data": null
}
     */

    @DeleteMapping("/delete3/{id}")        //test DELETE  from -> Postman http://localhost:8080/api/products/delete3/1
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") long id){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseWrapper("Products Successfully Deleted"));
    }


}
