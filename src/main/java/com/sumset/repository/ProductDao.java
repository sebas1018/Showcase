package com.sumset.repository;

import java.util.List;

import com.sumset.model.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}