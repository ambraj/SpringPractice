package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
						
		try {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Student> studentList = session.createQuery("from Student where lastName='Applebum'").list();
			
			for (Student temp : studentList) {
				System.out.println(temp);
			}
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
