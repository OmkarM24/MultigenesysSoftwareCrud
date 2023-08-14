package com.example.MultigenesysSoftwareCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MultigenesysSoftwareCrud.Dao.ProductDao;
import com.example.MultigenesysSoftwareCrud.Entity.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> findAll() {
		return productDao.findAll();
	}
	

	public String save(Product product) {
		return productDao.save(product);
	}
	
	public String delete(Long productId) {
		return productDao.delete(productId);
	}
	
	public String update(Product product,Long Id) {
	 return productDao.update(product, Id);
	}
	
}
