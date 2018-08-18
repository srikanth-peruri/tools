package speruri.jpa.interfaces;

import speruri.jpa.pojos.Application;

public interface IApplicationDAO {

	void addApplication(Application argApplication);

	void updateApplication(Application argApplication);

	void deleteAppliaction(String argId);

	void searchApplication(String argId);

	Application getApplicationById(String argId);

}
