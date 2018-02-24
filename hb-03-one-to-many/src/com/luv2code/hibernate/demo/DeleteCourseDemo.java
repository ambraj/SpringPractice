package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int id = 1;
			
			Course course = session.get(Course.class, id);
			
			System.out.println("Deleting courses:");
			
			session.delete(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
			factory.close();
		}

	}

}
