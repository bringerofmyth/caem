package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.User;

public class UserDao {

	public User addUser(User u) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(u);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return u;
	}

	public List<User> listUsers() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<User> users = null;
		try {
			tx = session.beginTransaction();
			users = session.createQuery("FROM User").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	public User updateUser(User user) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		User uUser = null;
		try {
			tx = session.beginTransaction();
			uUser = (User) session.get(User.class, user.getId());
			updateObject(uUser, user);
			session.update(uUser);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uUser;
	}

	private void updateObject(User taken, User given) {
		taken.setName(given.getName());
		taken.setPassword(given.getPassword());
		taken.setRole(given.getRole());
		taken.setSurname(given.getSurname());
		taken.setUserName(given.getUserName());
	}

	public User deleteUser(User dUser) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		User delUser = null;
		try {
			tx = session.beginTransaction();
			delUser = (User) session.get(User.class, dUser.getId());
			session.delete(delUser);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delUser;
	}

}
