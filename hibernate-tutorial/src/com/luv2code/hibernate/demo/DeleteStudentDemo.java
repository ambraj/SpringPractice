package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
						
		
		
		try {
			
			System.out.println("Deleting student object!");

			int studentId = 1;
			
			// create session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			session.delete(student);
			session.getTransaction().commit();
			System.out.println("deleted #1, Done!");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("deleted #2, Done!");
			
		} finally {
			factory.close();
		}

	}

}
