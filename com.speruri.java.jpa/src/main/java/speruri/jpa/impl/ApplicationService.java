package speruri.jpa.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import speruri.jpa.interfaces.IApplicationDAO;
import speruri.jpa.interfaces.IApplicationService;
import speruri.jpa.pojos.Application;

@Service
public class ApplicationService implements IApplicationService {

	@Autowired
	IApplicationDAO applicationDAO;

	@Override
	public void addApplication(Application argApplication) {
		this.applicationDAO.addApplication(argApplication);

	}

	@Override
	public void updateApplication(Application argApplication) {
		this.applicationDAO.updateApplication(argApplication);
	}

	@Override
	public void deleteAppliaction(String argId) {
		this.applicationDAO.deleteAppliaction(argId);
	}

	@Override
	public Application getApplicationById(String argId) {
		return this.applicationDAO.getApplicationById(argId);
	}

	@Override
	public boolean applicationExists(String argName, String argOwner) {
		return this.applicationDAO.applicationExists(argName, argOwner);
	}

}
