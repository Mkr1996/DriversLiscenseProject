
package com.infy.driversLiscense.validator;

import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;

public class AdminValidator {

	public static void validateAdminForUpdateProfile(Admin admin) throws Exception {

		if (!validateName(admin.getName()))
			throw new Exception("AdminValidator.INVALID_NAME");

		if (!validatePhoneNumber(admin.getPhoneNumber()))
			throw new Exception("AdminValidator.INVALID_PHONE_NUMBER");

	}

	public static void validateAdmin(Admin admin) throws Exception {

		if (!validateEmailId(admin.getEmailId()))
			throw new Exception("AdminValidator.INVALID_EMAIL_FORMAT");

		if (!validatePhoneNumber(admin.getPhoneNumber()))
			throw new Exception("AdminValidator.INVALID_PHONE_NUMBER");

		if (!validateName(admin.getName()))
			throw new Exception("AdminValidator.INVALID_NAME");

		if (!validatePassword(admin.getPassword()))
			throw new Exception("AdminValidator.INVALID_PASSWORD_FORMAT");

	}


	public static Boolean validateName(String name) {
		Boolean flag = false;
		if (!name.matches("[ ]*") && name.matches("([A-Za-z])+(\\s[A-Za-z]+)*"))
			flag = true;
		return flag;
	}

	public static Boolean validatePhoneNumber(String phoneNumber) {
		Boolean flag = false;
		if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10)
			flag = true;
		return flag;
	}

	public static Boolean validateEmailId(String emailId) {
		Boolean flag = false;
		if (emailId.matches("[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+"))
			flag = true;
		return flag;
	}

	public static Boolean validatePassword(String password) {
		Boolean flag = false;
		if (password.length() >= 6 && password.length() <= 20)
			if (password.matches(".*[A-Z]+.*"))
				if (password.matches(".*[a-z]+.*"))
					if (password.matches(".*[0-9]+.*"))
						if (password.matches(".*[^a-zA-Z-0-9].*"))
							flag = true;
		return flag;
	}

	public static Boolean validateCity(String city) {
		Boolean flag = false;
		if (!city.matches("[ ]*"))
			flag = true;
		return flag;

	}

	public static Boolean validateState(String state) {
		Boolean flag = false;
		if (!state.matches("[ ]*"))
			flag = true;
		return flag;

	}

	public static Boolean isValidAddressLine1(String addressLine1) {
		Boolean flag = false;
		if (!addressLine1.matches("[ ]*"))
			flag = true;
		return flag;

	}

	public static Boolean validateContactNumber(String phoneNumber) {

		Boolean flag = false;
		if (phoneNumber.matches("[0-9]+") && phoneNumber.length() == 10)
			flag = true;
		return flag;

	}

	public static Boolean validatePIN(String pin) {

		Boolean flag = false;
		if (pin.matches("[A-Za-z0-9]{6,10}"))
			flag = true;
		return flag;

	}
}
