package ru.gb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ru.gb.domain.Product;
import ru.gb.service.ProductService;

public class ProductServiceImpl implements ProductService {

  private static final int PRODUCTS_COUNTER = 10;
  private static final int MAX_COST = 100;

  @Override
  public List<Product> createProducts() {
    List<Product> products = new ArrayList<>();

    for (int i = 0; i < PRODUCTS_COUNTER; i++) {
      Product product = buildProduct(i);
      products.add(product);
    }
    return products;
  }

  private Product buildProduct(int productId) {
    Product product = new Product();
    product.setId(productId);
    product.setCost(new Random().nextInt(MAX_COST));
    product.setTitle(String.format("Product %d", productId));
    return product;
  }
}
