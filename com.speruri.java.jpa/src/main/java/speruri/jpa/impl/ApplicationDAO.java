package speruri.jpa.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import speruri.jpa.interfaces.IApplicationDAO;
import speruri.jpa.pojos.Application;

@Transactional
@Repository
public class ApplicationDAO implements IApplicationDAO {

	@PersistenceContext
	EntityManager entityManager;

	public void addApplication(Application argApplication) {
		this.entityManager.persist(argApplication);
	}

	public void updateApplication(Application argApplication) {
		Application application = this.getApplicationById(argApplication.getId());
		if (application != null) {
			application.setDescription(argApplication.getDescription());
			application.setName(argApplication.getName());
			application.setOwner(argApplication.getOwner());
			this.entityManager.flush();
		}

	}

	public void deleteAppliaction(String argId) {
		Application application = this.getApplicationById(argId);
		if (application != null) {
			this.entityManager.remove(application);
		}
	}

	public Application getApplicationById(String argId) {
		return this.entityManager.find(Application.class, argId);
	}

	public boolean applicationExists(String argName, String argOwner) {
		String jpql = "from Application as a where a.name = ? and a.owner = ?";
		int count = this.entityManager.createQuery(jpql).setParameter(0, argName).setParameter(1, argOwner)
				.executeUpdate();
		return count > 0;
	}

}
