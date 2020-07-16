package com.infy.ekart.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.infy.driversLiscense.dao.AdminDAO;
import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;
import com.infy.driversLiscense.utility.HashingUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class AdminDAOTest {
	@Autowired
	private AdminDAO adminDAO;

	@Test
	public void checkAvailabilityOfPhoneNumberValid() {
		Admin admin = new Admin();
		admin.setPhoneNumber("9988776655");
		adminDAO.checkAvailabilityOfPhoneNumber(admin.getPhoneNumber());
		Assert.assertTrue(true);

	}

	@Test
	public void checkAvailabilityOfPhoneNumberInValid() {
		Admin admin = new Admin();
		admin.setPhoneNumber("123ab45678");
		adminDAO.checkAvailabilityOfPhoneNumber(admin.getPhoneNumber());
		Assert.assertFalse(false);

	}

	@Test
	public void checkAvailabilityOfEmailIdValid() {
		Admin admin = new Admin();
		admin.setEmailId("Fahad@infosys.com");
		adminDAO.checkAvailabilityOfEmailId(admin.getEmailId());
		Assert.assertTrue(true);
	}

	@Test
	public void checkAvailabilityOfEmailIdInValid() {
		Admin admin = new Admin();
		admin.setEmailId("Fa@had1992@infosys.com");
		adminDAO.checkAvailabilityOfEmailId(admin.getEmailId());
		Assert.assertFalse(false);
	}

	@Test
	public void registerNewAdminValidDetails() {
		Admin admin = new Admin();
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setName("Fahad Rahman");
		admin.setPhoneNumber("9988776655");

		adminDAO.registerNewAdmin(admin);
		Assert.assertTrue(true);
	}

	@Test
	public void registerNewAdminInValidDetails() {
		Admin admin = new Admin();
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setName("Fahad  rahman");
		admin.setPhoneNumber("9988776655");

		adminDAO.registerNewAdmin(admin);
		Assert.assertFalse(false);
	}

	@Test
	public void updateAdminValidDetails() {
		Admin admin = new Admin();
		admin = adminDAO.getAdminByEmailId("mariya@infosys.com");
		admin.setName("Mariya M");
		admin.setPhoneNumber("7578116427");

		adminDAO.updateProfile(admin);
		Assert.assertTrue(true);
	}

	@Test
	public void changePasswordValidPassword() throws Exception {
		Admin admin = new Admin();
		String newHashedPassword = HashingUtility.getHashValue("JackP@123");
		admin.setPassword(newHashedPassword);
		admin.setEmailId("tom@infosys.com");
		adminDAO.changePassword(admin.getEmailId(), admin.getPassword());
		Assert.assertTrue(true);
	}

	@Test
	public void changePasswordInValidPassword() throws Exception {
		Admin admin = new Admin();
		String newHashedPassword = HashingUtility.getHashValue("J@123");
		admin.setPassword(newHashedPassword);
		admin.setEmailId("tom@infosys.com");
		adminDAO.changePassword(admin.getEmailId(), admin.getPassword());
		Assert.assertFalse(false);
	}


	@Test
	public void getAdminByPhoneNumberValidDetails() throws Exception {
		adminDAO.getAdminByPhoneNumber("7886189067");
	}

	@Test
	public void getAdminByPhoneNoInvalidDetails() throws Exception {
		adminDAO.getAdminByPhoneNumber("7886189066");
	}


	@Test
	public void getPasswordofAdminValidDetails() {
		adminDAO.getPasswordOfAdmin("Tom@infosys.com");

	}

	@Test
	public void getAdminbyEmailIdValidDetails() {
		adminDAO.getAdminByEmailId("Tom@infosys.com");
	}

	@Test
	public void getAdminbyEmailIdInValidDetails() {
		adminDAO.getAdminByEmailId("T12");
	}

}
