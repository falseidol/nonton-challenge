package service;

import model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static service.ProductsServiceImpl.productMap;

public class ProductsServiceImplTest {
    private final ProductsService productsService = new ProductsServiceImpl();
    Product product1;
    Product product2;
    Product product3;

    @Before
    public void setUp() {
        product1 = new Product("1", "product1");
        product2 = new Product("2", "product2");
        product3 = new Product("3", "product2");
    }

    @Test
    public void addProduct() {
        Assert.assertTrue(productsService.addProduct(product1));
        Assert.assertFalse(productsService.addProduct(product1));
        Assert.assertEquals(productMap.get(product1.getId()), product1);
        Assert.assertEquals(productMap.get(product1.getId()).getName(), product1.getName());
    }

    @Test
    public void deleteProduct() {
        productsService.addProduct(product1);
        Assert.assertTrue(productsService.deleteProduct(product1));
        Assert.assertFalse(productsService.deleteProduct(product1));
        Assert.assertNull(productMap.get(product1.getId()));
        Assert.assertEquals(0, productMap.size());
    }

    @Test
    public void getName() {
        productsService.addProduct(product2);
        Assert.assertEquals(productsService.getName(product2.getId()), productMap.get(product2.getId()).getName());
        Assert.assertEquals("", productsService.getName("5"));
    }

    @Test
    public void findByName() {
        productsService.addProduct(product2);
        productsService.addProduct(product3);
        Assert.assertEquals(2, productsService.findByName(product2.getName()).size());
    }
}