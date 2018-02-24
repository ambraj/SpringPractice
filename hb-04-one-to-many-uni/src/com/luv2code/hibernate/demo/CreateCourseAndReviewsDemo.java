package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
						
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			System.out.println("Creating Courses and reviews!");

			Course course = new Course("PacMan - How to score one million points");

			course.addReview(new Review("Great course."));
			course.addReview(new Review("you saved my life"));
			course.addReview(new Review("Cool course"));
			course.addReview(new Review("What a dumb course!!!"));

			System.out.println("Saving course:"+course);

			session.save(course);

			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
