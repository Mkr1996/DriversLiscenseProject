package com.infy.driversLiscense.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.driversLiscense.entity.AddressEntity;
import com.infy.driversLiscense.entity.AdminEntity;
import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Admin;


@SuppressWarnings("unchecked")
@Repository(value = "adminDAO")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public String authenticateAdmin(String emailId, String password) {

		Query query = entityManager.createQuery("select c from AdminEntity c where c.emailId = '" + emailId
				+ "' and c.password = '" + password + "'");
		System.out.println(query.getResultList());

		List<AdminEntity> adminEntities = query.getResultList();
		if (adminEntities.isEmpty())
			return null;

		return adminEntities.get(0).getEmailId();
	}

	@Override
	public String getPasswordOfAdmin(String emailId) {

		String password = null;
		emailId = emailId.toLowerCase();
		AdminEntity adminEntity = entityManager.find(AdminEntity.class, emailId);
		if (adminEntity != null) {
			password = adminEntity.getPassword();
		}

		return password;
	}

	@Override
	public Admin getAdminByEmailId(String emailId) {

		Admin admin = null;
		emailId = emailId.toLowerCase();
		List<Address> adminAddresses = new ArrayList<>();

		AdminEntity adminEntity = entityManager.find(AdminEntity.class, emailId);
		if (adminEntity != null) {
			admin = new Admin();
			admin.setEmailId(adminEntity.getEmailId());
			admin.setName(adminEntity.getName());
			admin.setPhoneNumber(adminEntity.getPhoneNumber());
			for (AddressEntity i : adminEntity.getAddressEntities()) {
				Address address = new Address();
				address.setAddressId(i.getAddressId());
				address.setStreetAddress1(i.getStreetaddress1());
				address.setStreetAddress2(i.getStreetAddress2());
				address.setCity(i.getCity());
				address.setZip(i.getZip());
				address.setState(i.getState());
				address.setCountry(i.getCountry());

				adminAddresses.add(address);
			}
			admin.setAddresses(adminAddresses);


		}

		return admin;
	}

	@Override
	public Boolean checkAvailabilityOfEmailId(String emailId) {

		Boolean flag = false;

		AdminEntity adminEntity = null;

		adminEntity = entityManager.find(AdminEntity.class, emailId);

		if (adminEntity == null)
			flag = true;

		return flag;
	}

	@Override
	public Boolean checkAvailabilityOfPhoneNumber(String phoneNumber) {

		Boolean flag = false;

		Query query = entityManager.createQuery("select c from AdminEntity c where c.phoneNumber = :phoneNumber");
		query.setParameter("phoneNumber", phoneNumber);

		List<AdminEntity> adminEntities = query.getResultList();

		if (adminEntities.isEmpty())
			flag = true;

		return flag;
	}

	@Override
	public String registerNewAdmin(Admin admin) {

		String registeredWithEmailId = null;

		AdminEntity adminEntity = new AdminEntity();

		adminEntity.setEmailId(admin.getEmailId());
		adminEntity.setName(admin.getName());
		adminEntity.setPassword(admin.getPassword());
		adminEntity.setPhoneNumber(admin.getPhoneNumber());

		entityManager.persist(adminEntity);

		registeredWithEmailId = adminEntity.getEmailId();

		return registeredWithEmailId;
	}

	@Override
	public Admin getAdminByPhoneNumber(String phoneNumber) {

		AdminEntity adminEntity = null;
		Admin admin = null;

		Query query = entityManager.createQuery("select c from AdminEntity c where c.phoneNumber = :phoneNumber");
		query.setParameter("phoneNumber", phoneNumber);
		List<AdminEntity> adminEntities = query.getResultList();

		if (!adminEntities.isEmpty()) {
			adminEntity = adminEntities.get(0);
			admin = new Admin();

			admin.setEmailId(adminEntity.getEmailId());
			admin.setName(adminEntity.getName());
			admin.setPhoneNumber(adminEntity.getPhoneNumber());
			List<Address> addList = new ArrayList<>();
			for (AddressEntity ae : adminEntity.getAddressEntities()) {
				Address a = new Address();
				a.setAddressId(ae.getAddressId());
				a.setStreetAddress1(ae.getStreetaddress1());
				a.setStreetAddress2(ae.getStreetAddress2());
				a.setCity(ae.getCity());
				a.setZip(ae.getZip());
				a.setState(ae.getState());
				a.setCountry(ae.getCountry());
				addList.add(a);
			}
			admin.setAddresses(addList);
		}

		return admin;
	}

	@Override
	public void updateProfile(Admin admin) {

		AdminEntity adminEntity = entityManager.find(AdminEntity.class, admin.getEmailId().toLowerCase());

		adminEntity.setName(admin.getName());
		adminEntity.setPhoneNumber(admin.getPhoneNumber());

	}

	@Override
	public void changePassword(String adminEmailId, String newHashedPassword) {

		AdminEntity adminEntity = entityManager.find(AdminEntity.class, adminEmailId);

		adminEntity.setPassword(newHashedPassword);

	}

}
