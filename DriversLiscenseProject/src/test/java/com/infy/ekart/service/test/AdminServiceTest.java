package com.infy.ekart.service.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infy.driversLiscense.dao.AdminDAO;
import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;
import com.infy.driversLiscense.service.AdminService;
import com.infy.driversLiscense.service.AdminServiceImpl;
import com.infy.driversLiscense.utility.HashingUtility;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
	

	@Mock
	private AdminDAO adminDAO;
	
	@InjectMocks
	private AdminService adminService=new AdminServiceImpl();
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Test
	public void authenticateAdminInValidDetails() throws Exception {
		
	
		String password = "Tom@123";
		Mockito.when(adminDAO.getPasswordOfAdmin(Mockito.anyString())).thenReturn(null);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_CREDENTIALS");
		adminService.authenticateAdmin("Toinfosys.com", password);
		
	}
	
	
	@Test
	public void authenticateAdminInValidDetails1() throws Exception {
		
		String password = "Tom23";
		String hashPassword = HashingUtility.getHashValue(password)+" ";
		Mockito.when(adminDAO.getPasswordOfAdmin(Mockito.anyString())).thenReturn(hashPassword);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_CREDENTIALS");
		adminService.authenticateAdmin("Tom@infosys.com", password);
		
	}
	
	@Test
	public void authenticateAdminInValidDetails2() throws Exception {
		

		String password = "Tom23";
		Mockito.when(adminDAO.getPasswordOfAdmin(Mockito.anyString())).thenReturn(null);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_CREDENTIALS");
		adminService.authenticateAdmin("Tom@infosys.com", password);
		
	}
	
/*	@Test
	public void addAddressValid() throws Exception{
		Address address=new Address();
		address.setAddressId(5000);
		address.setAddressLine1("Ist Main, Building No.3");
		address.setAddressLine2("Park Square");
		address.setCity("Los Angeles");
		address.setContactNumber("7886189066");
		address.setState("California");
		address.setPin("752110");
		Mockito.when(adminDAO.addAddress("",address)).thenReturn(1);
		Assert.assertNotNull(adminService.addAddress(" ", address));
	}
	
	@Test
	public void addAddressInValidCity() throws Exception{
		Address address=new Address();
		address.setAddressId(5000);
		address.setAddressLine1("Ist Main, Building No.3");
		address.setAddressLine2("Park Square");
		address.setCity(" ");
		address.setContactNumber("7886189066");
		address.setState("California");
		address.setPin("752110");
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_CITY");
		
		Mockito.when(adminDAO.addAddress("",address)).thenReturn(null);
		adminService.addAddress(" ", address);
	} 
	
	@Test
	public void addAddressInValidAddress() throws Exception{
		Address address=new Address();
		address.setAddressId(5000);
		address.setAddressLine1("");
		address.setAddressLine2("Park Square");
		address.setCity("Vegas");
		address.setContactNumber("7886189066");
		address.setState("California");
		address.setPin("752110");
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_ADDRESS_LINE_1");
		
		Mockito.when(adminDAO.addAddress("",address)).thenReturn(null);
		adminService.addAddress(" ", address);
	} 
	
	
	@Test
	public void addAddressInValidContact() throws Exception{
		Address address=new Address();
		address.setAddressId(5000);
		address.setAddressLine1("Ist Main,Door no.333");
		address.setAddressLine2("Park Square");
		address.setCity("Vegas");
		address.setContactNumber("7886dd189066");
		address.setState("California");
		address.setPin("752110");
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_CONTACT_NUMBER");
		
		Mockito.when(adminDAO.addAddress("",address)).thenReturn(null);
		adminService.addAddress(" ", address);
	} 
	
	@Test
	public void testChangePasswordInValidnewPassword() throws Exception{
		String newPassword="tim123#";
		String currentPassword="Tim!123";
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_NEW_PASSWORD");
		
		adminService.changePassword("",currentPassword,newPassword);
		
	}
	@Test
	public void testChangePasswordInValidCurrentPassword() throws Exception{
		String newPassword="Tim123#";
		String currentPassword="Tim!123";
		String hashCurrentPassword = HashingUtility.getHashValue(currentPassword+" g");
		String hashNewPassword = HashingUtility.getHashValue(newPassword);
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.INVALID_CURRENT_PASSWORD");
		
		Mockito.when(adminDAO.getPasswordOfAdmin(Mockito.anyString())).thenReturn(hashCurrentPassword);
		Mockito.doNothing().when(adminDAO).changePassword("", hashNewPassword);
		adminService.changePassword(Mockito.anyString(),currentPassword,newPassword);
		
	}
	@Test
	public void testDeleteAddress() throws Exception{
		Mockito.doNothing().when(adminDAO).deleteAddress(Mockito.anyString(), Mockito.anyInt());
		adminService.deleteAddress("",10);
		
	}
	@Test
	public void testRegisterNewAdmin() throws Exception{
		Admin admin=new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		Mockito.when(adminDAO.checkAvailabilityOfEmailId(Mockito.anyString())).thenReturn(true);
		Mockito.when(adminDAO.checkAvailabilityOfPhoneNumber(Mockito.anyString())).thenReturn(true);
		Mockito.when(adminDAO.registerNewAdmin(admin)).thenReturn("1");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}
	@Test
	public void testRegisterNewAdminPhoneInUse() throws Exception{
		Admin admin=new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.PHONE_NUMBER_ALREADY_IN_USE");
		
		Mockito.when(adminDAO.checkAvailabilityOfEmailId(Mockito.anyString())).thenReturn(true);
		Mockito.when(adminDAO.checkAvailabilityOfPhoneNumber(Mockito.anyString())).thenReturn(false);
		Mockito.when(adminDAO.registerNewAdmin(admin)).thenReturn("1");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}	*/
	@Test
	public void registerNewAdminExistingEmailID() throws Exception {
		
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.EMAIL_ID_ALREADY_IN_USE");
		
		Admin admin=new Admin();
		admin.setEmailId("Fahad@infosys.com");
		admin.setName("Fahad Rahman");
		admin.setPhoneNumber("9988776655");
		admin.setPassword("Fahad@123");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}
	
	@Test
	public void testRegisterNewAdminInValidEmail() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_EMAIL_FORMAT");
		Admin admin=new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fa@had@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}
	@Test
	public void testRegisterNewAdminInValidName() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_NAME");
		Admin admin=new Admin();
		admin.setName("12FahadRahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("9988776655");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}
	@Test
	public void testRegisterNewAdminInValidPassword() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PASSWORD");
		Admin admin=new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("a123");
		admin.setPhoneNumber("9988776655");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}
	
	@Test
	public void testRegisterNewAdminInValidPhoneNO() throws Exception{
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminValidator.INVALID_PHONE_NUMBER");
		Admin admin=new Admin();
		admin.setName("Fahad Rahman");
		admin.setEmailId("Fahad@infosys.com");
		admin.setPassword("Fahad@123");
		admin.setPhoneNumber("d987Ab321e");
		Assert.assertNotNull(adminService.registerNewAdmin(admin));
	}
	
	@Test
	public void testUpdateAdmin() throws Exception{
		Admin admin =new Admin();
		admin.setName("Jack Roger");
		admin.setPhoneNumber("9876543210");
		Mockito.when(adminDAO.getAdminByPhoneNumber(admin.getPhoneNumber())).thenReturn(null);
		Mockito.doNothing().when(adminDAO).updateProfile(admin);
		adminService.updateProfile(admin);
	}
	
	@Test
	public void testUpdateAdminValid() throws Exception{
		Admin admin =new Admin();
		admin.setName("Jack Roger");
		admin.setPhoneNumber("9876543210");
		admin.setEmailId("jack@gmail.com");
		Admin newAdmin =new Admin();
		newAdmin.setEmailId("jack@gmail.com");
		Mockito.when(adminDAO.getAdminByPhoneNumber(admin.getPhoneNumber())).thenReturn(newAdmin);
		Mockito.doNothing().when(adminDAO).updateProfile(admin);
		adminService.updateProfile(admin);
	}
	@Test
	public void testUpdateAdminInValid() throws Exception{
		Admin admin =new Admin();
		admin.setName("Jack Roger");
		admin.setPhoneNumber("9876543210");
		admin.setEmailId("jack@gmail.com");
		Admin newAdmin =new Admin();
		newAdmin.setEmailId("jack@g.com");
		expectedException.expect(Exception.class);
		expectedException.expectMessage("AdminService.PHONE_NUMBER_ALREADY_IN_USE");
		
		Mockito.when(adminDAO.getAdminByPhoneNumber(admin.getPhoneNumber())).thenReturn(newAdmin);
		Mockito.doNothing().when(adminDAO).updateProfile(admin);
		adminService.updateProfile(admin);
	}
}
