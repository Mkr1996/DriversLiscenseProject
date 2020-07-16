package com.infy.driversLiscense.dao;

import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;

public interface AdminDAO {

	public Boolean checkAvailabilityOfEmailId(String emailId);

	public Boolean checkAvailabilityOfPhoneNumber(String phoneNumber);

	public String registerNewAdmin(Admin Admin);

	public String authenticateAdmin(String emailId, String password);

	public String getPasswordOfAdmin(String emailId);

	public Admin getAdminByEmailId(String emailId);

	public Admin getAdminByPhoneNumber(String phoneNumber);

	public void updateProfile(Admin Admin);

	public void changePassword(String AdminEmailId, String newHashedPassword);

	
}
