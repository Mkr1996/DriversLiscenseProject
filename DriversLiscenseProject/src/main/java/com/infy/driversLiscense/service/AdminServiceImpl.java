package com.infy.driversLiscense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.driversLiscense.dao.AdminDAO;
import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;
import com.infy.driversLiscense.validator.AdminValidator;

@Service(value = "adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	@Override
	public Admin authenticateAdmin(String emailId, String password) throws Exception {

		Admin admin = null;
		String adminEmailIdFromDAO = adminDAO.authenticateAdmin(emailId.toLowerCase(), password);
		if (adminEmailIdFromDAO != null) {

			admin = adminDAO.getAdminByEmailId(adminEmailIdFromDAO);
		} else
			throw new Exception("AdminService.INVALID_CREDENTIALS");

		return admin;

	}

	@Override
	public String registerNewAdmin(Admin admin) throws Exception {

		String registeredWithEmailId = null;

		AdminValidator.validateAdmin(admin);
		Boolean emailAvailable = adminDAO.checkAvailabilityOfEmailId(admin.getEmailId().toLowerCase());
		Boolean phoneNumberAvailable = adminDAO.checkAvailabilityOfPhoneNumber(admin.getPhoneNumber());
		if (emailAvailable) {
			if (phoneNumberAvailable) {
				String emailIdToDB = admin.getEmailId().toLowerCase();

				admin.setEmailId(emailIdToDB);

				registeredWithEmailId = adminDAO.registerNewAdmin(admin);

			} else {
				throw new Exception("AdminService.PHONE_NUMBER_ALREADY_IN_USE");
			}
		} else {
			throw new Exception("AdminService.EMAIL_ID_ALREADY_IN_USE");
		}

		return registeredWithEmailId;
	}

	@Override
	public void updateProfile(Admin admin) throws Exception {

		Admin newAdmin = null;
		AdminValidator.validateAdminForUpdateProfile(admin);

		newAdmin = adminDAO.getAdminByPhoneNumber(admin.getPhoneNumber());
		if (newAdmin == null) {
			adminDAO.updateProfile(admin);
		} else {
			if (newAdmin.getEmailId().equals(admin.getEmailId()))
				adminDAO.updateProfile(admin);
			else
				throw new Exception("AdminService.PHONE_NUMBER_ALREADY_IN_USE");
		}
	}

	@Override
	public void changePassword(String adminEmailId, String currentPassword, String newPassword) throws Exception {

		Boolean validPassword = AdminValidator.validatePassword(newPassword);
		if (!validPassword)
			throw new Exception("AdminService.INVALID_NEW_PASSWORD");

		String passwordFromDB = adminDAO.getPasswordOfAdmin(adminEmailId);

		if (!passwordFromDB.equals(currentPassword))
			throw new Exception("AdminService.INVALID_CURRENT_PASSWORD");

		if (currentPassword.equals(newPassword))
			throw new Exception("AdminService.OLD_PASSWORD_NEW_PASSWORD_SAME");

		adminDAO.changePassword(adminEmailId, newPassword);

	}

}
