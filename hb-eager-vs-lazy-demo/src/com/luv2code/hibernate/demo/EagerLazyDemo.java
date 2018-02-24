package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 1;

			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("instructor: " + instructor);
			System.out.println("associated courses: " + instructor.getCourses());
			
			session.getTransaction().commit();
			session.close();

			

			System.out.println("Done!");
			
			System.out.println("associated courses: " + instructor.getCourses());

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			
			factory.close();
		}

	}

}
