package com.infy.ekart.validator.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;
import com.infy.driversLiscense.validator.AdminValidator;

public class AdminValidatorTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void validateAdminValidFormat() throws Exception {
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidEmailId() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_EMAIL_FORMAT");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fa@had@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName1() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("12FahadRahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName2() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("Fahad  Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName3() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("FahadRahman  ");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName4() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("#FahadRahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName5() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("  ");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName6() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("Fahad12Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidName7() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName(" Fahad  Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPhoneNumber1() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PHONE_NUMBER");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("d987Ab321e");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPhoneNumber2() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PHONE_NUMBER");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("12345");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword1() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("a123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword2() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("ABcd4567894321bdeklmsbx");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword3() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("jackjill123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword4() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("JACKJILL123");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword5() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("45@123456789");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword6() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Jack12345");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword7() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("!@#$%^&*");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminInvalidPassword8() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin = new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword(" asSDFADfg#$%");
		admin.setPhoneNumber("9988776655");
		AdminValidator.validateAdmin(admin);
	}

	@Test
	public void validateAdminNameValidFormat1() throws Exception {
		Boolean result = AdminValidator.validateName("Jack Roger");
		Assert.assertTrue(result);
	}

	@Test
	public void validateAdminNameValidFormat2() throws Exception {
		Boolean result = AdminValidator.validateName("Jack");
		Assert.assertTrue(result);
	}

	@Test
	public void validateAdminNameInvalidFormat1() throws Exception {
		Boolean result = AdminValidator.validateName(" ");
		Assert.assertFalse(result);
	}

	@Test
	public void validateAdminNameInvalidFormat2() throws Exception {
		Boolean result = AdminValidator.validateName("1");
		Assert.assertFalse(result);
	}

	@Test
	public void validateAdminNameInvalidFormat3() throws Exception {
		Boolean result = AdminValidator.validateName("1 Jack ");
		Assert.assertFalse(result);
	}

	@Test
	public void validateAdminPhoneNumberValidFormat() throws Exception {
		Boolean result = AdminValidator.validatePhoneNumber("9876543210");
		Assert.assertTrue(result);

	}

	@Test
	public void validateAdminPhoneNumberInvalidFormat1() throws Exception {
		Boolean result = AdminValidator.validatePhoneNumber("987654321");
		Assert.assertFalse(result);

	}

	@Test
	public void validateAdminPhoneNumberInvalidFormat2() throws Exception {
		Boolean result = AdminValidator.validatePhoneNumber("A987654321");
		Assert.assertFalse(result);

	}

	@Test
	public void validateEmailidValidFormat() throws Exception {
		Boolean result = AdminValidator.validateEmailId("Tom@infosys.com");
		Assert.assertTrue(result);
	}

	@Test
	public void validateEmailidInValidFormat() throws Exception {
		Boolean result = AdminValidator.validateEmailId("Tom12@infosys1.c2om");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePasswordInValidFormat1() throws Exception {
		Boolean result = AdminValidator.validatePassword("Tom@");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePasswordInValidFormat2() throws Exception {
		Boolean result = AdminValidator.validatePassword("Tom@");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePasswordInValidFormat8() throws Exception {
		Boolean result = AdminValidator.validatePassword("45658963214785");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePasswordInValidFormat3() throws Exception {
		Boolean result = AdminValidator.validatePassword("A123456");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePasswordInValidFormat5() throws Exception {
		Boolean result = AdminValidator.validatePassword("a123456A");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePasswordInValidFormat6() throws Exception {
		Boolean result = AdminValidator.validatePassword("a123.{jyj");
		Assert.assertFalse(result);
	}

	@Test
	public void validateCityValidFormat() throws Exception {
		Boolean result = AdminValidator.validateCity("Los Angeles");
		Assert.assertTrue(result);
	}

	@Test
	public void validateCityInvalidFormat() throws Exception {
		Boolean result = AdminValidator.validateCity("  ");
		Assert.assertFalse(result);
	}

	@Test
	public void validateStateValidFormat() throws Exception {
		Boolean result = AdminValidator.validateState("California");
		Assert.assertTrue(result);
	}

	@Test
	public void validateStateInvalidFormat() throws Exception {
		Boolean result = AdminValidator.validateState("  ");
		Assert.assertFalse(result);
	}

	@Test
	public void isValidAddressLine1ValidFormat() throws Exception {
		Boolean result = AdminValidator.isValidAddressLine1("Ist Main, Building No.3");
		Assert.assertTrue(result);
	}

	@Test
	public void isValidAddressLine1InvalidFormat() throws Exception {
		Boolean result = AdminValidator.isValidAddressLine1(" ");
		Assert.assertFalse(result);
	}

	@Test
	public void validateContactNumberValidFormat() throws Exception {
		Boolean result = AdminValidator.validateContactNumber("9956451659");
		Assert.assertTrue(result);
	}

	@Test
	public void validateContactNumberInvalidFormat1() throws Exception {
		Boolean result = AdminValidator.validateContactNumber("995645159");
		Assert.assertFalse(result);
	}

	@Test
	public void validateContactNumberInvalidFormat2() throws Exception {
		Boolean result = AdminValidator.validateContactNumber("995A645159");
		Assert.assertFalse(result);
	}

	@Test
	public void validatePINValidDetails() throws Exception {
		Boolean result = AdminValidator.validatePIN("567576");
		Assert.assertTrue(result);
	}

	@Test
	public void validatePINInalidDetails() throws Exception {
		Boolean result = AdminValidator.validatePIN("56776");
		Assert.assertFalse(result);
	}

	@Test
	public void validateAdminForUpdateProfileValidFormat() throws Exception {
		Admin admin = new Admin();
		admin.setName("Jack Roger");
		admin.setPhoneNumber("9876543210");
		AdminValidator.validateAdminForUpdateProfile(admin);
	}

	@Test
	public void validateAdminForUpdateProfileInvalidFormat1() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PHONE_NUMBER");
		Admin admin = new Admin();
		admin.setName("Jack");
		admin.setPhoneNumber("987654321");
		AdminValidator.validateAdminForUpdateProfile(admin);
	}

	@Test
	public void validateAdminForUpdateProfileInvalidFormat2() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin = new Admin();
		admin.setName("1Jack");
		admin.setPhoneNumber("9876543210");
		AdminValidator.validateAdminForUpdateProfile(admin);
	}

}
