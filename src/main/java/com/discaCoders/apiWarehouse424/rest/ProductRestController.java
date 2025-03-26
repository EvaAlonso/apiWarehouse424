package com.discaCoders.apiWarehouse424.rest;

import com.discaCoders.apiWarehouse424.Entity.Product;
import com.discaCoders.apiWarehouse424.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductRestController {
    private final ProductDAO productDAO;

    @Autowired
    public ProductRestController(ProductDAO theProductDAO){
        productDAO = theProductDAO;
    }
    @GetMapping("/products")
    public List<Product> findAll(){
        return productDAO.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
       Product product = this.productDAO.findById(id);
        if(product == null){
            throw new RuntimeException("Product id not found - " + id);
        }
        return product;
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product theProduct){
        this.productDAO.save(theProduct);
        return theProduct;
    }
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product theProduct){
        this.productDAO.update(theProduct);
        return theProduct;
    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable int id){
        this.productDAO.delete(id);
        return "Deleted productId: " + id;
    }
}
