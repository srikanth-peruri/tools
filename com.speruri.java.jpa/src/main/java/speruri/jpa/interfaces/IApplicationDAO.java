package speruri.jpa.interfaces;

import speruri.jpa.pojos.Application;

public interface IApplicationDAO {

	void addApplication(Application argApplication);

	void updateApplication(Application argApplication);

	void deleteAppliaction(String argId);

	Application getApplicationById(String argId);

	boolean applicationExists(String argName, String argOwner);

}
