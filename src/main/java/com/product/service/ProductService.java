package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Products;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;

	public void saveProduct(Products products) {
		
		productRepo.save(products);
		
	}

	public List<Products> findAll() {
		
		return productRepo.findAll();
	}

	public Optional<Products> findById(long id) {
		
		return productRepo.findById(id) ;
	}

	public void deleteById1(long id) {
		
		productRepo.deleteById(id);
	}

	public void save(Products products) {
		// TODO Auto-generated method stub
		productRepo.save(products);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}

	public List<Products> getdataproducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

}
