package ru.geekbrains.patterns.lesson6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductService {
    protected ProductMapper productMapper;
    protected Map<Integer, Product> productMap = new HashMap<>();

    public ProductService(ProductMapper productMapper) {
        this.productMapper  = productMapper;
    }

    public Product addProduct(String name, int price) throws SQLException, RecordNotFoundException {
        int productId = productMapper.insert(name, price);
        System.out.println(productId);
        Product newProduct = getProduct(productId);
        productMap.put(newProduct.getIdProduct(), newProduct);
        return newProduct;
    }

    public Product getProduct(Integer productId) throws SQLException, RecordNotFoundException {
        if (productMap.get(productId) != null)
            return productMap.get(productId);

        Product product = productMapper.findById(productId);
        productMap.put(product.getIdProduct(), product);
        return product;
    }

    public Product editProduct(int id, String name, int price) throws SQLException, RecordNotFoundException {
        productMapper.update(id, name, price);
        Product product = productMapper.findById(id);
        productMap.put(id, product);
        return product;
    }

    public void removeProduct(int id) throws SQLException, RecordNotFoundException {
        productMapper.delete(id);
        productMap.remove(id);
    }
}
