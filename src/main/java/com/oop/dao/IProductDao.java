package com.oop.dao;

import com.oop.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductDao extends CrudRepository<Product, Long> {}
