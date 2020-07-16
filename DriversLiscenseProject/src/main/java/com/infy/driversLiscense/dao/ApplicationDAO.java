package com.infy.driversLiscense.dao;

import java.util.List;
import com.infy.driversLiscense.entity.ApplicationEntity;
import com.infy.driversLiscense.model.Application;

public interface ApplicationDAO {
	public abstract boolean applicationExists(Integer applicationId);
	public abstract Integer addApplication(Application application);
	public abstract Integer deleteApplication(Integer applicationId);
	public abstract List<ApplicationEntity> getApplications();
	public abstract Integer approveApplication(Integer applicationId);
}
