package com.discaCoders.apiWarehouse424.dao;

import com.discaCoders.apiWarehouse424.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDAOImpl implements ProductDAO{
    private EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public String save(Product theProduct){
        this.entityManager.persist(theProduct);
        return "Producto " + theProduct.getName() + " creado";
    }

    @Override
    public Product findById(Integer id) {
        return this.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> theQuery;
        theQuery =
                entityManager.createQuery("FROM Product", Product.class);
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public String update(Product theProduct){
        entityManager.merge(theProduct);
        return theProduct.getName() + " modificado";
    }
    @Override
    @Transactional
    public String delete(Integer id){
        Product product = this.entityManager.find(Product.class, id);
        entityManager.remove(product);
        return product.getName() + " borrado";
    }
}
