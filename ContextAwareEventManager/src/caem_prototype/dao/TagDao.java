package caem_prototype.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import caem_prototype.entity.Tag;

public class TagDao {

	public Tag addTag(Tag u) {
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

	public List<Tag> listTags() {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		List<Tag> tags = null;
		try {
			tx = session.beginTransaction();
			tags = session.createQuery("FROM Tag").list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tags;
	}

	public Tag updateTag(Tag tag) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Tag uTag = null;
		try {
			tx = session.beginTransaction();
			uTag = (Tag) session.get(Tag.class, tag.getId());
			updateObject(uTag, tag);
			session.update(uTag);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return uTag;
	}

	private void updateObject(Tag taken, Tag given) {
		taken.setTitle(taken.getTitle());

	}

	public Tag deleteTag(Tag dTag) {
		Session session = Dao.createSessionFactory().openSession();
		Transaction tx = null;
		Tag delTag = null;
		try {
			tx = session.beginTransaction();
			delTag = (Tag) session.get(Tag.class, dTag.getId());
			session.delete(delTag);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return delTag;
	}
}
