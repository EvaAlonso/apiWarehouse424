package com.discaCoders.apiWarehouse424.dao;

import com.discaCoders.apiWarehouse424.Entity.Product;


import java.util.List;


public interface ProductDAO {
    List<Product>findAll();
    String save(Product theProduct);
    Product findById(Integer id);
    String update(Product theProduct);
    String delete(Integer id);

}
