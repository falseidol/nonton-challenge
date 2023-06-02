package service;

import model.Product;

import java.util.*;

/**
 * Product functions impl
 */
public class ProductsServiceImpl implements ProductsService {
    static Map<String, Product> productMap = new HashMap<>();

    public static void main(String[] args) {
        Product product1 = new Product("1", "product1");
        Product product2 = new Product("2", "product2");
        Product product3 = new Product("3", "product3");
        ProductsService productsService = new ProductsServiceImpl();
        productsService.addProduct(product1);
        productsService.addProduct(product1);
        productsService.addProduct(product2);
        productsService.addProduct(product3);
        productsService.deleteProduct(product1);
        productsService.addProduct(product1);
        productsService.getName("2");
        productsService.findByName("product1");
    }

    @Override
    public boolean addProduct(Product product) {
        if (product.getId() == null && Integer.parseInt(product.getId()) < 0) {
            System.out.println("id == null or < 0");
            return false;
        }
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
            System.out.println("product with id " + product.getId() + "and name " + product.getName() + " was added. ");
            return true;
        }
        System.out.println("product with same id already exists.");
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        if (product.getId() == null && Integer.parseInt(product.getId()) < 0) {
            System.out.println("id == null or < 0");
            return false;
        }
        if (productMap.containsKey(product.getId())) {
            productMap.remove(product.getId());
            System.out.println("product with id " + product.getId() + " was deleted.");
            return true;
        }
        System.out.println("product with this id doesn't exist.");
        return false;
    }

    @Override
    public String getName(String id) {
        if (id == null) {
            return "";
        }
        if (productMap.containsKey(id)) {
            System.out.println(productMap.get(id).getName());
            return productMap.get(id).getName();
        }
        return "";
    }

    @Override
    public List findByName(String name) {
        List<Product> list = productMap.values().stream().filter(x -> x.getName().equals(name)).toList();
        List<String> ids = new ArrayList<>();
        if (name == null) {
            return Collections.emptyList();
        } else {
            for (Product product : list) {
                ids.add(product.getId());
            }
            System.out.println(ids);
            return ids;
        }
    }
}