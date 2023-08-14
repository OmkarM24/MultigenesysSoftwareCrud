package com.example.MultigenesysSoftwareCrud.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.MultigenesysSoftwareCrud.Entity.Project;

@Repository
public class ProjectDao {
	
	@Autowired
	SessionFactory sf;
	
	public String save(Project project) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(transaction);
		transaction.commit();
		session.close();
		return "Data Inserted..!!";
	}
	
	public List<Project> list() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Project.class);
		List<Project> l =criteria.list();
		session.close();
		return l;
	}
	
	public String update(Project project,Long Id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Project pjt=null;
		pjt = session.get(Project.class, Id);
		if(pjt != null) {
			pjt.setProjectName(project.getProjectName());
		    pjt.setDateofStart(project.getDateofStart());
		    pjt.setTeamSize(project.getTeamSize());
		}
		else if(pjt == null) {
			return "Project not found :"+Id;
		}
		transaction.commit();
		session.close();
		return "Data Updated..!!";	
	}
	
	public String delete(Long Id) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		Project project = session.get(Project.class, Id);
		session.delete(project);
		transaction.commit();
		session.close();
		return "Data Deleted..!!";
	}

}
