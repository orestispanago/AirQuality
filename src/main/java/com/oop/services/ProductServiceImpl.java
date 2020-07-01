package com.oop.services;

import com.oop.dao.IProductDao;
import com.oop.entities.Product;
import com.oop.entities.ProductType;
import com.oop.exceptions.ProductNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao productDao;

    @Autowired
    IProductTypeService productTypeService;
    
    @Override
    public Product getById(long productId) {
        return productDao.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<Product> productEntity = productDao.findAll();
        List<Product> products = (List<Product>) productEntity;
        return products;
    }

    @Override
    public Product save(Product product) {
        if (product == null) {
            return null;
        }
        ProductType productType = productTypeService.getById(product.getProductType().getId());
        product.setProductType(productType);
        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {
        if(!productDao.existsById(product.getId()))throw new ProductNotFoundException();
        return productDao.save(product);
    }

    @Override
    public void delete(Product product) {
        if(!productDao.existsById(product.getId()))throw new ProductNotFoundException();
        productDao.deleteById(product.getId());
    }
    
    public void deleteById(long productId){
        if(!productDao.existsById(productId)) throw new ProductNotFoundException();
        productDao.deleteById(productId);
    }
}
