package com.example.product_service.service.impl;

import com.example.product_service.domain.Product;
import com.example.product_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    //模拟数据库存储
    private static final Map<Integer,Product> daoMap = new HashMap<>();
    static {
        Product product1 = new Product(1,"iphonex",999,10);
        Product product2 = new Product(2,"冰箱",888,10);
        Product product3 = new Product(3,"电视",777,10);
        Product product4 = new Product(4,"洗衣机",666,10);
        Product product5 = new Product(5,"汽车",555,10);
        Product product6 = new Product(6,"java",444,10);

        daoMap.put(product1.getId(),product1);
        daoMap.put(product2.getId(),product2);
        daoMap.put(product3.getId(),product3);
        daoMap.put(product4.getId(),product4);
        daoMap.put(product5.getId(),product5);
        daoMap.put(product6.getId(),product6);

    }


    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
