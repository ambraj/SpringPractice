package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			System.out.println("Creating Courses!");

			int id = 1;

			Instructor instructor = session.get(Instructor.class, id);

			Course course1 = new Course("Air Guitar");
			Course course2 = new Course("Java");

			instructor.add(course1);
			instructor.add(course2);

			System.out.println("Saving courses:");

			session.save(course1);
			session.save(course2);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
