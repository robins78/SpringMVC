package com.org.robin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;



import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.robin.DTO.Address;
import com.org.robin.utils.HibernateUtil;

@Repository
public class AddressDao {
	@Autowired
	private EntityManagerFactory entityManagerfactory;

	public List<Address> getData() {
		
		/* Query qery =
				 entityManagerfactory.createEntityManager().createQuery("from Address");
		 List<Address> returnData = qery.getResultList();*/
		 
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Address> returnData;
		try {
			Query query = session.createQuery("from Address");
			returnData = query.list();
		} finally {
			session.flush();
			session.close();
		}

		return returnData;
	}

	public String saveData(Address data) {
		String msg = "success";
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(data);

		} catch (Exception e) {
			msg = e.toString();
		} finally {
			session.getTransaction().commit();
			session.flush();
			session.close();
		}
		return msg;
		/*
		 * try{ entityManager.persist(data); }catch(Exception e){ msg =
		 * e.toString(); }
		 */
	}
}
