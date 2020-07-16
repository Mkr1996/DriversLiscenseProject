package com.infy.driversLiscense.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;
import com.infy.driversLiscense.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("AdminAPI")
public class adminAPI {
	@Autowired
	private AdminService adminService;

	@Autowired
	private Environment environment;

	static Logger logger = LogManager.getLogger(adminAPI.class.getName());

	@PostMapping(value = "adminLogin")
	public ResponseEntity<Admin> authenticateCustomer(@RequestBody Admin admin) throws Exception {
		try {
			String message = "ADMIN TRYING TO LOGIN, VALIDATING CREDENTIALS. CUSTOMER EMAIL ID: "
					+ admin.getEmailId();
			logger.info(message);

			Admin adminfromDB = adminService.authenticateAdmin(admin.getEmailId(),
					admin.getPassword());

			logger.info("ADMIN LOGIN SUCCESS, ADMIN EMAIL : " + adminfromDB.getEmailId());

			return new ResponseEntity<Admin>(adminfromDB, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}

	@PostMapping(value = "registerAdmin")
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) throws Exception {
		try {
			logger.info("ADMIN TRYING TO REGISTER. ADMIN EMAIL ID: " + admin.getEmailId());

			String registeredWithEmailID = adminService.registerNewAdmin(admin);
			registeredWithEmailID = environment.getProperty("CustomerAPI.CUSTOMER_REGISTRATION_SUCCESS")
					+ registeredWithEmailID;
			return new ResponseEntity<String>(registeredWithEmailID, HttpStatus.OK);

		} catch (Exception e) {
			if (e.getMessage().contains("Validator")) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, environment.getProperty(e.getMessage()));
			}
			throw new ResponseStatusException(HttpStatus.CONFLICT, environment.getProperty(e.getMessage()));
		}
	}

	@PostMapping(value = "updateProfile")
	public ResponseEntity<String> updateAdminProfile(@RequestBody Admin admin) throws Exception {
		try {
			adminService.updateProfile(admin);
			String modificationSuccessMsg = environment.getProperty("CustomerAPI.CUSTOMER_DETAILS_UPDATION_SUCCESS");
			return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, environment.getProperty(e.getMessage()));
		}

	}

	@PostMapping(value = "changePassword")
	public ResponseEntity<String> changePassword(@RequestBody Admin admin) throws Exception {

		try {
			adminService.changePassword(admin.getEmailId(), admin.getPassword(), admin.getNewPassword());
			String modificationSuccessMsg = environment.getProperty("CustomerAPI.CUSTOMER_PASSWORD_CHANGE_SUCCESS");
			return new ResponseEntity<String>(modificationSuccessMsg, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, environment.getProperty(e.getMessage()));
		}

	}

}
