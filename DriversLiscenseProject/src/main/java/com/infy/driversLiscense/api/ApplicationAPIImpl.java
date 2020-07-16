package com.infy.driversLiscense.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.driversLiscense.model.Application;
import com.infy.driversLiscense.service.ApplicationService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping("ApplicationAPI")
@Api(value="Drivers License Management System", description="Managing admin operations such as adding and deleting applications")
public class ApplicationAPIImpl implements ApplicationAPI {
	
	@Autowired
	private ApplicationService applicationService;

	@Override
	@PostMapping(value = "Application",consumes ="application/json")
	public ResponseEntity<String> addApplication(@Valid Application application) {
		// TODO Auto-generated method stub
		Integer id = applicationService.addApplication(application);
		String message = "The following Application has been successfully added with Application Id: " + id;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@Override
	@PostMapping(value = "Application/{applicationId}")
	public ResponseEntity<Integer> deleteApplication(Integer applicationId) {
		// TODO Auto-generated method stub
		Integer result = applicationService.deleteApplication(applicationId);
		ResponseEntity<Integer> re = new ResponseEntity<Integer>(result, HttpStatus.OK);
		return re;
	}

	@Override
	@GetMapping(value = "getAllApplications")
	public ResponseEntity<List<Application>> getApplications() {
		// TODO Auto-generated method stub
		List<Application> applicationList=null;
		applicationList = applicationService.getApplications();
		ResponseEntity<List<Application>> response = new ResponseEntity<List<Application>>(applicationList, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<Integer> approveApplication(Integer applicationId) {
		// TODO Auto-generated method stub
		Integer result = applicationService.approveApplication(applicationId);
		ResponseEntity<Integer> re = new ResponseEntity<Integer>(result, HttpStatus.OK);
		return re;
	}

}
