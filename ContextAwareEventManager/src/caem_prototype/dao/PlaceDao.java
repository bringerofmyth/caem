package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.Place;

public class PlaceDao {

	public Place addPlace(Place u) {
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

	public List<Place> listPlaces() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<Place> places = null;
		try {
			tx = session.beginTransaction();
			places = session.createQuery("FROM Place").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return places;
	}

	public Place bringPlace(Place place) {
		Session session = Dao.createSessionFactory().openSession();
		Place delPlace = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			delPlace = (Place) session.get(Place.class, place.getId());

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			session.close();
		}
		return delPlace;
	}
	public Place updatePlace(Place place) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Place uPlace = null;
		try {
			tx = session.beginTransaction();
			uPlace = (Place) session.get(Place.class, place.getId());
			updateObject(uPlace, place);
			session.update(uPlace);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uPlace;
	}

	private void updateObject(Place taken, Place given) {
		taken.setAddress(given.getAddress());

		taken.setDescription(given.getDescription());
		taken.setName(given.getName());
		taken.setOpenHours(given.getOpenHours());
		taken.setPhone(given.getPhone());
		taken.setPosition(given.getPosition());
		taken.setTags(given.getTags());

	}

	public Place deletePlace(Place dPlace) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Place delPlace = null;
		try {
			tx = session.beginTransaction();
			delPlace = (Place) session.get(Place.class, dPlace.getId());
			session.delete(delPlace);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delPlace;
	}
}
