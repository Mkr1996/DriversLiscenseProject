package com.infy.driversLiscense.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.driversLiscense.entity.AddressEntity;
import com.infy.driversLiscense.entity.ApplicationEntity;
import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Application;

@Repository(value = "applicationDAO")
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public boolean applicationExists(Integer applicationId) {
		// TODO Auto-generated method stub
		Optional<ApplicationEntity> checkNull = Optional.ofNullable(entityManager.find(ApplicationEntity.class,applicationId));
		if(checkNull.isPresent()){
			return true;
		}
		else
		{
		return false;
		}
	}

	@Override
	public Integer addApplication(Application application) {
		// TODO Auto-generated method stub
		ApplicationEntity newApplication = new ApplicationEntity();
		newApplication.setApplciationFor(application.getApplciationFor());
		newApplication.setApplicationType(application.getApplicationType());
		newApplication.setBirthSurname(application.getBirthSurname());
		newApplication.setClassName(application.getClassName());
		newApplication.setDateOfBirth(application.getDateOfBirth());
		newApplication.setDateOfSignature(application.getDateOfSignature());
		newApplication.setEmail(application.getEmail());
		newApplication.setEthnicity(application.getEthnicity());
		newApplication.setEyeColor(application.getEyeColor());
		newApplication.setFathersLastName(application.getFathersLastName());
		newApplication.setFirstName(application.getFirstName());
		newApplication.setHairColor(application.getHairColor());
		newApplication.setHeight(application.getHeight());
		newApplication.setLastName(application.getLastName());
		newApplication.setMiddleName(application.getMiddleName());
		newApplication.setMothersMiddleName(application.getMothersMiddleName());
		newApplication.setMotorCycle(application.getMotorCycle());
		newApplication.setPhoneNo(application.getPhoneNo());
		newApplication.setPlaceOfBirth(application.getPlaceOfBirth());
		newApplication.setRace(application.getRace());
		newApplication.setSex(application.getSex());
		newApplication.setSignature(application.getSignature());
		newApplication.setSsn(application.getSsn());
		newApplication.setSuffix(application.getSuffix());
		newApplication.setWeight(application.getWeight());
		AddressEntity newAddress = null;
		List<AddressEntity> newAddresses = new ArrayList<AddressEntity>();
		for(Address address : application.getAddresses()){
			newAddress = new AddressEntity();
			newAddress.setStreetaddress1(address.getStreetAddress1());
			newAddress.setStreetAddress2(address.getStreetAddress2());
			newAddress.setCity(address.getCity());
			newAddress.setState(address.getState());
			newAddress.setZip(address.getZip());
			newAddress.setCountry(address.getCountry());
			newAddresses.add(newAddress);
		}
		newApplication.setAddresses(newAddresses);
		entityManager.persist(newApplication);
		return newApplication.getApplicationId();
	}

	@Override
	public Integer deleteApplication(Integer applicationId) {
		// TODO Auto-generated method stub
		Integer id = null;
		Optional<ApplicationEntity> application = Optional.ofNullable(entityManager.find(ApplicationEntity.class, applicationId));
		if(application.isPresent()){
			ApplicationEntity aE = application.get();
			aE.setAddresses(null);
			id = aE.getApplicationId();
			entityManager.remove(aE);
		}
		return id;
	}

	@Override
	public List<ApplicationEntity> getApplications() {
		// TODO Auto-generated method stub
		String dft = "SELECT a FROM ApplicationEntity a";
		Query query = entityManager.createQuery(dft);
		List<ApplicationEntity> applicationList = query.getResultList();
		return applicationList;
	}

	@Override
	public Integer approveApplication(Integer applicationId) {
		// TODO Auto-generated method stub
		Integer id = null;
		Optional<ApplicationEntity> application = Optional.ofNullable(entityManager.find(ApplicationEntity.class, applicationId));
		if(application.isPresent()){
			ApplicationEntity aE = application.get();
			aE.setApproved(true);
			id=aE.getApplicationId();
		}
		return id;
	}

}
