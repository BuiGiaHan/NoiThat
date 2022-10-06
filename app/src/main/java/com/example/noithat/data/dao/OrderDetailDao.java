package com.example.noithat.data.dao;

import com.example.noithat.data.dao.model.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    OrderDetail find(int id);
    OrderDetail findByProductId(int productId);
    List<OrderDetail> all();
    void insert(OrderDetail product);
    void update(OrderDetail product);
    void delete(int id);
    void deleteAll();
}
