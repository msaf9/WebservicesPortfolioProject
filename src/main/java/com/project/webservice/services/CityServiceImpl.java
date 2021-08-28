package com.project.webservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.webservice.entity.City;
import com.project.webservice.repository.CityRepository;
import com.project.webservice.request.CityRequest;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public String addNewCity(CityRequest cityRequest) {
		String message = null;
		if (cityRequest != null) {

			City c = new City();
			c.setCityName(cityRequest.getCityName());
			c.setCountry(cityRequest.getCountry());
			c.setState(cityRequest.getState());
			c.setCityDescription(cityRequest.getCityDescription());
			cityRepository.save(c);
			message = "Saved";

		}
		return message;
	}

	@Override
	public List<City> viewAllCity() {
		return (List<City>) cityRepository.findAll();
	}

}
