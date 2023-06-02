package service;

import model.Product;

import java.util.List;

/**
 * Product functions interface
 */
public interface ProductsService {
    boolean addProduct(Product product);

    boolean deleteProduct(Product product);

    String getName(String id);

    List findByName(String name);
}