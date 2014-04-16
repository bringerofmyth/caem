
package caem_prototype.dbmanager;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import caem_prototype.entity.User;
import caem_prototype.namingvalues.NamingValues.Role;
public class DbManager {
	private static SessionFactory factory; 
	public static void main(String[] args)
	{ 
		try{

			factory = new AnnotationConfiguration(). configure(). 
					//addPackage("com.xyz") //add package if used. 
					addAnnotatedClass(User.class). buildSessionFactory();
		}catch (Throwable ex) 
		{ 
			System.err.println("Failed to create sessionFactory object." + ex); 
			throw new ExceptionInInitializerError(ex);
		} 
		DbManager ME = new DbManager();
		/* Add few employee records in database */ 
		Integer empID1 = ME
				.addEmployee("Zara", "Ali", "user1", "q", Role.Admin);
		Integer empID2 = ME.addEmployee("Daisy", "Das", "user2", "q",
				Role.Attender);
		Integer empID3 = ME.addEmployee("John", "Paul", "user2", "q",
				Role.EventOwner);
		ME.listEmployees();
	}
	/* List down all the employees */ 
	/*
	 * 
	 */

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, String username,
			String pass, Role role)
	{ 
		Session session = factory.openSession(); 
		Transaction tx = null; Integer employeeID = null; 
		try{ 
			tx = session.beginTransaction(); 
			User employee = new User();
			employee.setName(fname);
			employee.setSurname(lname);
			employee.setRole(role);
			employee.setUserName(username);
			employee.setPassword(pass);
			employee.setRole(Role.Admin);
			employeeID = (Integer) session.save(employee);
			tx.commit(); 
		}catch (HibernateException e)
		{ if (tx!=null) {
			tx.rollback();
		}
		e.printStackTrace(); 
		}finally { session.close(); } 
		return employeeID; 
	}
	public void listEmployees( )
	{
		Session session = factory.openSession();
		Transaction tx = null;
		try{ tx = session.beginTransaction();
		List employees = session.createQuery("FROM User").list(); 
		for (Iterator iterator = employees.iterator(); iterator.hasNext();)
		{ 
			User employee = (User) iterator.next();
			System.out.print("First Name: " + employee.getName()); 
			System.out.print(" Last Name: " + employee.getSurname());
			System.out.println(" User name: " + employee.getPassword());
		} 
		tx.commit();
		}catch (HibernateException e)
		{ 
			if (tx!=null) {
				tx.rollback();
			} 
			e.printStackTrace(); 
		}finally { session.close(); 
		} 
	}
}

