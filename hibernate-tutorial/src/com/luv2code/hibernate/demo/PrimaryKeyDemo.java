package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
						
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating 3 student objects!");
			
			Student student1 = new Student("John", "Doe", "john@gmail.com");
			Student student2 = new Student("Mary", "Public", "mary@gmail.com");
			Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving student object!");
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}
	
}
