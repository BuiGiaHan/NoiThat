package org.coolstyles.baitap.data.dao;

import org.coolstyles.baitap.data.model.Product;

import java.util.List;

public interface ProductDao {
    Product find(int id);
    List<Product> all();
    void insert(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> findByName(String name);
}
