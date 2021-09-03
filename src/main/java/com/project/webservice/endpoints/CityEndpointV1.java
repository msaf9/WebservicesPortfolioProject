package com.project.webservice.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.webservice.entity.City;
import com.project.webservice.request.CityRequest;
import com.project.webservice.response.CityResponse;
import com.project.webservice.services.CityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value = "/city", tags = "City Controller")
@RestController
@RequestMapping(path = "/city")
public class CityEndpointV1 {

	@Autowired
	private CityService cityService;

	@ApiOperation(value = "Create city", response = String.class)
	@PostMapping(path = "/add")
	public String addNewCity(@RequestBody CityRequest cityRequest) {
		return cityService.addNewCity(cityRequest);
	}

	@ApiOperation(value = "Fetch all cities", response = City.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "SUCCESS", response = City.class),
			@ApiResponse(code = 401, message = "UNAUTHORIZED", response = City.class),
			@ApiResponse(code = 403, message = "FORBIDDEN", response = City.class),
			@ApiResponse(code = 404, message = "NOT FOUND") })
	@GetMapping(path = "/all")
	public List<City> viewAllCity() {
		return cityService.viewAllCity();
	}

	@ApiOperation(value = "Delete city by id", response = String.class)
	@DeleteMapping(path = "delete")
	public String deleteCity(int cityId) {
		return cityService.deleteCity(cityId);
	}

	@ApiOperation(value = "Delete all cities", response = String.class)
	@DeleteMapping(path = "/deleteAll")
	public String deleteAll() {
		return cityService.deleteAll();
	}

	@ApiOperation(value = "Update city by id", response = CityResponse.class)
	@PutMapping(path = "/update")
	public CityResponse editCity(@RequestBody City cityRequest) {
		return cityService.editCity(cityRequest);
	}

	@ApiOperation(value = "Fetch city by id", response = City.class)
	@GetMapping(path = "/city/{id}")
	public City viewCity(int id) {
		return cityService.viewCity(id);
	}
}