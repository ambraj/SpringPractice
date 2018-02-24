package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
						
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating instructor object!");
			
//			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			
//			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Coding!!");
			
			Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar!!");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving the instructor:");
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
