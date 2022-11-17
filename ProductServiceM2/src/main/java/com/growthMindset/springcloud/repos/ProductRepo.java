package com.growthMindset.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growthMindset.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {



}
