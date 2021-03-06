package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = 
				new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
						
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			int studentId = 2;
			Student student = session.get(Student.class, studentId);
			System.out.println("Student: "+student);
			System.out.println("courses: "+student.getCourses());
			
			Course course1 = new Course("Rubik's Cube");
			Course course2 = new Course("Game Development");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
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
