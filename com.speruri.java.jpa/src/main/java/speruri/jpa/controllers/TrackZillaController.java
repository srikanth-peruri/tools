package speruri.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import speruri.jpa.interfaces.IApplicationService;
import speruri.jpa.pojos.Application;

@RestController
@RequestMapping("/tza")
public class TrackZillaController {

	@Autowired
	IApplicationService applicationService;

	@GetMapping("/application/{id}")
	public ResponseEntity<Application> getApplicationById(@PathVariable("id") String argId) {
		Application application = this.applicationService.getApplicationById(argId);
		return new ResponseEntity<Application>(application, HttpStatus.OK);
	}

}
