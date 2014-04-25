package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.Photo;

public class PhotoDao {

	public Photo addPhoto(Photo u) {
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

	public List<Photo> listPhotos() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<Photo> photos = null;
		try {
			tx = session.beginTransaction();
			photos = session.createQuery("FROM Photo").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return photos;
	}

	public Photo updatePhoto(Photo photo) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Photo uPhoto = null;
		try {
			tx = session.beginTransaction();
			uPhoto = (Photo) session.get(Photo.class, photo.getId());
			updateObject(uPhoto, photo);
			session.update(uPhoto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uPhoto;
	}

	private void updateObject(Photo taken, Photo given) {
		taken.setDiskUrl(given.getDiskUrl());
		taken.setIsOwner(given.getIsOwner());
		taken.setPlace(given.getPlace());
		taken.setUrl(given.getDiskUrl());
	}

	public Photo deletePhoto(Photo dPhoto) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Photo delPhoto = null;
		try {
			tx = session.beginTransaction();
			delPhoto = (Photo) session.get(Photo.class, dPhoto.getId());
			session.delete(delPhoto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delPhoto;
	}
}
