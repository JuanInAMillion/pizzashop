package com.revature.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		
		User testUser = new User("trevor.mulrenin@yahoo.com", "password", "1111 Mulberry Lane", "Trevor", "Mulrenin"
				,"586-111-1111", "111-111-1111");
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println(session);
		
		Transaction transaction = session.beginTransaction();
		
		session.update(testUser);
		transaction.commit();
		
		
		
		

	}

}
