package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory sf = HibernateUtil1.getSessionFactory();
		
		Session ss = sf.openSession();
		
		Student stu = new Student();
		
		stu.setName("Nilesh");
		stu.setAddress("Nashik");
		
		ss.save(stu);
		
		ss.beginTransaction().commit();
		
		System.out.println("Data Stored");
	}

}
