package com.ab.myonlinedairy.dao;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ab.myonlinedairy.entity.Dairy;

@Repository
public class DairyDAOImpl implements DairyDAO {

	@Autowired
	private EntityManager entityManager;

	private Logger logger = Logger.getLogger(getClass().getName());

	@Override
	public List<Dairy> getDairyEntries(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Dairy> query = session.createQuery(
				"from Dairy d where d.addedBy=:userId and d.isCurrent = 1 order by d.entryOn DESC", Dairy.class);
		query.setParameter("userId", id);
		List<Dairy> entries = query.getResultList();
		return entries;
	}

	@Override
	public void saveDairyEntry(Dairy dairy) {
		Session session = entityManager.unwrap(Session.class);
		try {
			session.saveOrUpdate(dairy);
		} catch (ConstraintViolationException e) {
			// this happens if hacker tries to add the entry for already existing one.
		} catch (Exception e) {
			// P1 - need to add logger here.
		}
	}

	@Override
	public Dairy getDairyEntry(int userId, int dairyId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Dairy> query = session
				.createQuery("from Dairy d where d.addedBy=:addedBy and d.id=:id and d.isCurrent = 1", Dairy.class);
		query.setParameter("addedBy", userId);
		query.setParameter("id", dairyId);
		Dairy dairy = null;
		try {
			dairy = query.getSingleResult();
		} catch (NonUniqueResultException e) {
			logger.warning("STRANGE: Found more than one entry on same date for a user with id: "+userId);
		} catch(NoResultException e ) {
			logger.warning("User has already deleted the record or probably some db operation has taken place");
		}
		return dairy;
	}

	@Override
	public void softDeleteDairyEntry(int userId, int dairyId) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("UPDATE Dairy d SET d.isCurrent = 0 where d.addedBy=:addedBy and d.id=:id");
		query.setParameter("addedBy", userId);
		query.setParameter("id", dairyId);
		query.executeUpdate();

	}

	@Override
	public boolean checkDuplicateRecords(int userId, Date entryOn) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery(
				"SELECT COUNT(*) from Dairy d where d.addedBy=:addedBy and d.entryOn=:entryOn and d.isCurrent=1");
		query.setParameter("addedBy", userId);
		query.setParameter("entryOn", entryOn);
		Long count = (Long) query.uniqueResult();

		if (count == 0) {
			return false;
		}
		return true;
	}
}
