package com.infy.driversLiscense.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.driversLiscense.dao.ApplicationDAO;
import com.infy.driversLiscense.entity.AddressEntity;
import com.infy.driversLiscense.entity.ApplicationEntity;
import com.infy.driversLiscense.exception.ApplicationNotFoundException;
import com.infy.driversLiscense.exception.NoApplicationsAvailableException;
import com.infy.driversLiscense.model.Address;
import com.infy.driversLiscense.model.Application;

@Service(value="applicationService")
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	ApplicationDAO applicationDAO;
	
	@Override
	public Integer addApplication(Application application) {
		// TODO Auto-generated method stub
		Integer id = applicationDAO.addApplication(application);
		return id;
	}

	@Override
	public Integer deleteApplication(Integer applicationId) {
		// TODO Auto-generated method stub
		Optional<Integer> id = Optional.of(applicationDAO.deleteApplication(applicationId));
		if(!id.isPresent()){
			throw new ApplicationNotFoundException(applicationId);
		}
		return id.get();
	}

	@Override
	public List<Application> getApplications() {
		// TODO Auto-generated method stub
		List<Application> applications = null;
		List<ApplicationEntity> applicationList = applicationDAO.getApplications();
		Optional<List<ApplicationEntity>> checkNull = Optional.ofNullable(applicationList);
		if(checkNull.isPresent()){
			applications = new ArrayList<Application>();
			for(ApplicationEntity application : applicationList){
				Application newApplication = new Application();
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
				Address newAddress = null;
				List<Address> newAddresses = new ArrayList<Address>();
				for(AddressEntity address : application.getAddresses()){
					newAddress = new Address();
					newAddress.setAddressId(address.getAddressId());
					newAddress.setStreetAddress1(address.getStreetaddress1());
					newAddress.setStreetAddress2(address.getStreetAddress2());
					newAddress.setCity(address.getCity());
					newAddress.setState(address.getState());
					newAddress.setZip(address.getZip());
					newAddress.setCountry(address.getCountry());
					newAddresses.add(newAddress);

			}
			newApplication.setAddresses(newAddresses);
		}
	}
	else{
		throw new NoApplicationsAvailableException();
	}
	return applications;
	}

	@Override
	public Integer approveApplication(Integer applicationId) {
		// TODO Auto-generated method stub
		Optional<Integer> id = Optional.of(applicationDAO.approveApplication(applicationId));
		if(!id.isPresent()){
			throw new ApplicationNotFoundException(applicationId);
		}
		return id.get();
	}
	
}

