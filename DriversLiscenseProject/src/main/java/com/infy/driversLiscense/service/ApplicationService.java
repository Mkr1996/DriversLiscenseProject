package com.infy.driversLiscense.service;

import java.util.List;

import com.infy.driversLiscense.entity.ApplicationEntity;
import com.infy.driversLiscense.model.Application;

public interface ApplicationService {

	public abstract Integer addApplication(Application application);
	public abstract Integer deleteApplication(Integer applicationId);
	public abstract List<Application> getApplications();
	public abstract Integer approveApplication(Integer applicationId);
}
