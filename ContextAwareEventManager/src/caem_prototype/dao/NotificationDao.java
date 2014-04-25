package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.Notification;

public class NotificationDao {
	public Notification addNotification(Notification n) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(n);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return n;
	}

	public List<Notification> listNotifications() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<Notification> notifications = null;
		try {
			tx = session.beginTransaction();
			notifications = session.createQuery("FROM Notification").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return notifications;
	}

	public Notification updateNotification(Notification notification) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Notification uNotification = null;
		try {
			tx = session.beginTransaction();
			uNotification = (Notification) session.get(Notification.class,
					notification.getId());
			updateObject(uNotification, notification);
			session.update(uNotification);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uNotification;
	}

	private void updateObject(Notification taken, Notification given) {
		taken.setDescription(given.getDescription());
		taken.setTitle(given.getTitle());

	}

	public Notification deleteEmployee(Notification dNotification) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Notification delNotification = null;
		try {
			tx = session.beginTransaction();
			delNotification = (Notification) session.get(Notification.class,
					dNotification.getId());
			session.delete(delNotification);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delNotification;
	}

}
