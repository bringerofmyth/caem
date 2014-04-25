package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.Event;

public class EventDao {
	public Event addEvent(Event u) {
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

	public List<Event> listEvents() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<Event> events = null;
		try {
			tx = session.beginTransaction();
			events = session.createQuery("FROM Event").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return events;
	}

	public Event updateEvent(Event event) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Event uEvent = null;
		try {
			tx = session.beginTransaction();
			uEvent = (Event) session.get(Event.class, event.getId());
			updateObject(uEvent, event);
			session.update(uEvent);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uEvent;
	}

	private void updateObject(Event taken, Event given) {
		taken.setEventType(given.getEventType());
		taken.setFinishTime(given.getFinishTime());
		taken.setIsRecurrent(given.getIsRecurrent());
		taken.setRecurrentUntil(given.getRecurrentUntil());
		taken.setStartTime(given.getStartTime());
		taken.setTitle(given.getTitle());
		taken.setTags(given.getTags());

	}

	public Event bringEvent(Event event) {
		Session session = Dao.createSessionFactory().openSession();
		Event delEvent = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			delEvent = (Event) session.get(Event.class, event.getId());

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
		return delEvent;
	}

	public Event deleteEvent(Event dEvent) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Event delEvent = null;
		try {
			tx = session.beginTransaction();
			delEvent = (Event) session.get(Event.class, dEvent.getId());
			session.delete(delEvent);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delEvent;
	}
}
