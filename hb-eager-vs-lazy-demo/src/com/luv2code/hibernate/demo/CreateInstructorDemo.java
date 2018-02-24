package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating instructor object!");

			Instructor instructor = new Instructor("Susan", "Public", "susan@luv2code.com");

			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Gamer!!");

			instructor.setInstructorDetail(instructorDetail);

			session.beginTransaction();

			System.out.println("Saving the instructor:");

			session.save(instructor);

			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}

	}

}
