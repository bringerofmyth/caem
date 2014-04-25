package caem_prototype.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import caem_prototype.dao.UserDao;
import caem_prototype.entity.User;
import caem_prototype.namingvalues.NamingValues;

public class HibernateMain {

	public static void main(String[] args) {

		User user1 = new User();
		user1.setName("Melihq");
		user1.setPassword("q");
		user1.setRole(NamingValues.Role.Admin);
		user1.setSurname("Gur");
		user1.setUserName("admin");

		UserDao uDao = new UserDao();
		uDao.addUser(user1);
		System.out.println("listing");
		List<User> users = uDao.listUsers();
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getName() + " "
					+ user.getSurname() + " " + user.getUserName());
		}
		System.out.println("listing");
		user1.setName("updated name");
		user1.setSurname("updated surname");
		uDao.updateUser(user1);
		users = uDao.listUsers();
		System.out.println("listing");
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getName() + " "
					+ user.getSurname() + " " + user.getUserName());
		}

		User user2 = new User();
		user2.setName("Melihq");
		user2.setPassword("q");
		user2.setRole(NamingValues.Role.Admin);
		user2.setSurname("Gur");
		user2.setUserName("admin");
		uDao.addUser(user2);


		users = uDao.listUsers();
		System.out.println("listing");
		for (User user : users) {
			System.out.println("lastone");
			System.out.println(user.getId() + " " + user.getName() + " "
					+ user.getSurname() + " " + user.getUserName());
		}


	}

	public static void listEmployees() {
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM User").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				User employee = (User) iterator.next();
				System.out.print("ID: " + employee.getId());
				System.out.print("First Name: " + employee.getName());
				System.out.print(" Last Name: " + employee.getSurname());
				System.out.println(" Username: " + employee.getUserName());
				System.out.println();
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void updateEmployee(Integer EmployeeID, String name) {
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User employee = (User) session.get(User.class, EmployeeID);
			employee.setName(name);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void deleteEmployee(Integer userID) {
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User employee = (User) session.get(User.class, userID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static Integer addUser(User user) {
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory(serviceRegistry);
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();

			employeeID = (Integer) session.save(user);
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
		return employeeID;
	}
}
