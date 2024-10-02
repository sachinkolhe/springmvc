package com.newgen.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newgen.main.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
