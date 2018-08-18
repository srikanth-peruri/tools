package speruri.jpa;

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
		application.setDescription(argApplication.getDescription());
		application.setName(argApplication.getName());
		application.setOwner(argApplication.getOwner());
		this.entityManager.flush();

	}

	public void deleteAppliaction(String argId) {
		// TODO Auto-generated method stub

	}

	public void searchApplication(String argId) {
		// TODO Auto-generated method stub

	}

	public Application getApplicationById(String argId) {
		return this.entityManager.find(Application.class, argId);
	}

}
