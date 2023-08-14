package com.example.MultigenesysSoftwareCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MultigenesysSoftwareCrud.Entity.Product;
import com.example.MultigenesysSoftwareCrud.Service.ProductService;
 
@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/list")
	public List<Product> findAll() {
		return productService.findAll();	
	}
	
	@PostMapping("/insert")
	public String save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@DeleteMapping("deletebyid/{productId}")
	public String delete(@PathVariable Long productId) {
		return productService.delete(productId);
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Product product,@PathVariable Long id) {
		return productService.update(product, id);
	}

}
