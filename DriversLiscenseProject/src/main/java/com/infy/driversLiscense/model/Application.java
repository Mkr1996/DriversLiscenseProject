package com.infy.driversLiscense.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.infy.driversLiscense.entity.AddressEntity;

public class Application {
private Integer applicationId;
	
	private String applciationFor;
	private String className;
	private String motorCycle;
	private String applicationType;
	private String suffix;
	private String lastName;
	private String firstName;
	private String middleName;
	private String birthSurname;
	private String ssn;
	private LocalDate dateOfBirth;
	private String sex;
	private Integer height;
	private Integer weight;
	private String eyeColor;
	private String hairColor;
	private String race;
	private String ethnicity;
	private String placeOfBirth;
	private String fathersLastName;
	private String mothersMiddleName;
	private Long phoneNo;
	private String email;
	private String signature;
	private LocalDate dateOfSignature;
	private boolean approved = false;
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	private List<Address> addresses;
	
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplciationFor() {
		return applciationFor;
	}
	public void setApplciationFor(String applciationFor) {
		this.applciationFor = applciationFor;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMotorCycle() {
		return motorCycle;
	}
	public void setMotorCycle(String motorCycle) {
		this.motorCycle = motorCycle;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getBirthSurname() {
		return birthSurname;
	}
	public void setBirthSurname(String birthSurname) {
		this.birthSurname = birthSurname;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getFathersLastName() {
		return fathersLastName;
	}
	public void setFathersLastName(String fathersLastName) {
		this.fathersLastName = fathersLastName;
	}
	public String getMothersMiddleName() {
		return mothersMiddleName;
	}
	public void setMothersMiddleName(String mothersMiddleName) {
		this.mothersMiddleName = mothersMiddleName;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public LocalDate getDateOfSignature() {
		return dateOfSignature;
	}
	public void setDateOfSignature(LocalDate dateOfSignature) {
		this.dateOfSignature = dateOfSignature;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
