package caem_prototype.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import caem_prototype.entity.User;
import caem_prototype.namingvalues.NamingValues;

public class HibernateMain {

	public static void main(String[] args) {
		SessionFactory factory;
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex)

		{
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			User user1 = new User();
			user1.setName("Melihq");
			user1.setPassword("q");
			user1.setRole(NamingValues.Role.Admin);
			user1.setSurname("Gur");
			user1.setUserName("admin");
			employeeID = (Integer) session.save(user1);
			tx.commit();
			System.out.println(employeeID);
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
