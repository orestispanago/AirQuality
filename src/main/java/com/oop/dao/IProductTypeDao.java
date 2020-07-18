package com.oop.dao;

import com.oop.entities.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeDao extends CrudRepository<ProductType, Long> {}
