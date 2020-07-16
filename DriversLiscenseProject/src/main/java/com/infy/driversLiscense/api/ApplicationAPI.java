package com.infy.driversLiscense.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infy.driversLiscense.model.Application;
import com.infy.driversLiscense.service.ApplicationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ApplicationAPI {
	@ApiOperation(value = "Add a new application to the airport database", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Application Added successfully"),
	@ApiResponse(code = 404, message = ""), @ApiResponse(code = 400, message = "")})
	public abstract ResponseEntity<String> addApplication(@Valid @RequestBody Application application);
	  @ApiOperation(value = "Delete application from data base based on application Id provided", response = String.class)
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Application deleted successfully", response = String.class),
	        @ApiResponse(code = 403, message = ""),
	        @ApiResponse(code = 400, message = "Bad Request"),
	        @ApiResponse(code = 500, message = "Some unknown error occurred!") })
	public ResponseEntity<Integer> deleteApplication(@PathVariable("applicationId") Integer applicationId);
	 	 @ApiOperation(value = "Fetch all the applications from database", response = ApplicationService.class)
	 	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched all applications successfully"),
	 	@ApiResponse(code = 404, message = "applications not found"), @ApiResponse(code = 400, message = "")})
	 	 public ResponseEntity<List<Application>> getApplications();
	 	 @ApiOperation(value = "Approve application from data base based on application Id provided", response = String.class)
		    @ApiResponses(value = { 
		        @ApiResponse(code = 200, message = "Application approved successfully", response = String.class),
		        @ApiResponse(code = 403, message = ""),
		        @ApiResponse(code = 400, message = "Bad Request"),
		        @ApiResponse(code = 500, message = "Some unknown error occurred!") })
		public ResponseEntity<Integer> approveApplication(@PathVariable("applicationId") Integer applicationId);
}
