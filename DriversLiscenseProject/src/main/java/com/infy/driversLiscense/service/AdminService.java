package com.infy.driversLiscense.service;

import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;

public interface AdminService {

	public Admin authenticateAdmin(String emailId, String password) throws Exception;

	public String registerNewAdmin(Admin Admin) throws Exception;

	public void updateProfile(Admin Admin) throws Exception;

	public void changePassword(String sellerEmailId, String currentPassword, String newPassword) throws Exception;

}
