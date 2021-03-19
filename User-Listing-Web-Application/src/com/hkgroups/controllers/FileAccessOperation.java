package com.hkgroups.controllers;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hkgroups.entity.ImageDataModel;

public class FileAccessOperation {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(ImageDataModel.class).buildSessionFactory();
	
	public void addImages(ImageDataModel files) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(files);
		session.getTransaction().commit();
		System.out.println(files.getImagename()+"added");
	}
	
	public List<ImageDataModel> imagelist(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ImageDataModel> list = session.createQuery("from imagedata").getResultList();
//		session.getTransaction().commit();
		return list;
	}
}
