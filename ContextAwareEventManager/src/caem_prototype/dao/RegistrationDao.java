package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.Registration;

public class RegistrationDao {

	public Registration addRegistration(Registration u) {
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

	public List<Registration> listRegistrations() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<Registration> registrations = null;
		try {
			tx = session.beginTransaction();
			registrations = session.createQuery("FROM Registration").list();
			if (registrations != null && !registrations.isEmpty()) {
				for (Registration registration : registrations) {
					System.out.println(registration.getId() + " "
							+ registration.getStatus());
				}
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
		return registrations;
	}

	public Registration bringRegistration(Registration registration) {
		Session session = Dao.createSessionFactory().openSession();
		Registration delRegistration = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			delRegistration = (Registration) session.get(Registration.class,
					registration.getId());

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
		return delRegistration;
	}
	public Registration updateRegistration(Registration registration) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Registration uRegistration = null;
		try {
			tx = session.beginTransaction();
			uRegistration = (Registration) session.get(Registration.class,
					registration.getId());
			updateObject(uRegistration, registration);
			session.update(uRegistration);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uRegistration;
	}

	private void updateObject(Registration taken, Registration given) {
		taken.setEvent(given.getEvent());
		taken.setStatus(given.getStatus());
		taken.setTimeOfRegistration(given.getTimeOfRegistration());
		taken.setUser(given.getUser());

	}

	public Registration deleteRegistration(Registration dRegistration) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Registration delRegistration = null;
		try {
			tx = session.beginTransaction();
			delRegistration = (Registration) session.get(Registration.class,
					dRegistration.getId());
			session.delete(delRegistration);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delRegistration;
	}
}
