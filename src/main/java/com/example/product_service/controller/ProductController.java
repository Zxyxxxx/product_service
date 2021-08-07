package com.example.product_service.controller;


import com.example.product_service.domain.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品服务类
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value("${server.port}")
    private String port;


    @Autowired
    private ProductService productService;

    /**
     * 列表
     * @return
     */
    @RequestMapping("/list")
    public Object listProduct(){
        return productService.listProduct();
    }

    /**
     * 根据id查询商品详情
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public Object findById(int id){

        Product product = productService.findById(id);
        Product result = new Product();
        //对象拷贝
        BeanUtils.copyProperties(product,result);
        //模拟eureka负载均衡
        result.setName(result.getName()+"data from port:"+port);
        return result;
    }


}
