package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			
			System.out.println("Creating new student object!");
			
			Student student = new Student("Daffy", "Duck", "daffy@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student!");
			
			session.save(student);
			
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student: id: "+student.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Get complete: "+myStudent);
			
			System.out.println("Getting ");
			
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
