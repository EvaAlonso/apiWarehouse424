package com.discaCoders.apiWarehouse424.dao;

import com.discaCoders.apiWarehouse424.Entity.Product;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ProductDAOImplements {
    @Transactional
    String save(Product theProduct);

    Product findById(Integer id);

    List<Product> findAll();

    @Transactional
    String update(Product theProduct);

    @Transactional
    String delete(Integer id);
}
