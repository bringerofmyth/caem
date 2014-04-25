package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.UserLocation;

public class UserLocationDao {

	public UserLocation addUserLocation(UserLocation u) {
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

	public List<UserLocation> listUserLocations() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<UserLocation> userLocations = null;
		try {
			tx = session.beginTransaction();
			userLocations = session.createQuery("FROM User_Location").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userLocations;
	}

	public UserLocation bringUserLocation(UserLocation userLocation) {
		Session session = Dao.createSessionFactory().openSession();
		UserLocation delUserLocation = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			delUserLocation = (UserLocation) session.get(UserLocation.class,
					userLocation.getId());

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
		return delUserLocation;
	}
	public UserLocation updateUserLocation(UserLocation userLocation) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		UserLocation uUserLocation = null;
		try {
			tx = session.beginTransaction();
			uUserLocation = (UserLocation) session.get(UserLocation.class,
					userLocation.getId());
			updateObject(uUserLocation, userLocation);
			session.update(uUserLocation);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uUserLocation;
	}

	private void updateObject(UserLocation taken, UserLocation given) {
		taken.setTime(given.getTime());
		taken.setPlace(given.getPlace());
		taken.setUser(given.getUser());

	}

	public UserLocation deleteUserLocation(UserLocation dUserLocation) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		UserLocation delUserLocation = null;
		try {
			tx = session.beginTransaction();
			delUserLocation = (UserLocation) session.get(UserLocation.class,
					dUserLocation.getId());
			session.delete(delUserLocation);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delUserLocation;
	}
}
