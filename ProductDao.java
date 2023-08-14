package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Product;
import com.example.MultigenesysSoftwareCrud.Entity.Student;



@Repository
public class ProductDao {
	

	
	@Autowired
	SessionFactory sf;
	
	public List<Product> findAll() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> l=criteria.list();
		session.close();
		return l;
	}
	
	public String save(Product product) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(product);
		tr.commit();
		session.close();
		return "Inserted..";
	}
	
	public String delete(Long productId) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Product product =session.get(Product.class, productId);
		session.delete(product);
		tr.commit();
		session.close();
		return "Deleted..";
	}
	
	public String update(Product product,Long Id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Product prd=null;
		prd=session.get(Product.class, Id);
		if(prd != null) {
			prd.setProductName(product.getProductName());
			prd.setProductPrice(product.getProductPrice());
			prd.setProductVersion(product.getProductVersion());
		}
		else if(prd == null) {
			return "product not found :"+Id;
		}
		session.update(prd);
		tr.commit();
		session.close();
		return "updated";
	}
}
