package com.org.robin.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.robin.utils.HibernateUtil;

@Repository
public class UserDao {

	@Autowired
	private EntityManagerFactory entityManagerfactory;

	public String isValiduser(String userId, String pwd) {

		/*
		 * Query qery =
		 * entityManagerfactory.createEntityManager().createQuery("from Address"
		 * ); List<Address> returnData = qery.getResultList();
		 */
		Session session = HibernateUtil.getSessionFactory().openSession();
		String returnData = "";
		try {
			Query query = session.createSQLQuery("select username from Users where id = ? and password = ?");
			query.setString(0, userId);
			query.setString(1, pwd);
			returnData = (String)query.uniqueResult();
		} finally {
			session.flush();
			session.close();
		}

		return returnData;
	}

}
