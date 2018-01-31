package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.User;
import com.example.domain.UserData;
	
@Service
public class ApiServiceImpl implements ApiService {

	private RestTemplate restTemplate;

	public ApiServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<User> getUsers(Integer limit) {

		// create configuration class
		// inject an instance of the RestTemplate
		// using method getForObject
		// passing in url (should externalize it into a property file)
		// map to object UserData
		// binding is happening based on the name of the POJO. Jackson bind the object
		// from get request.
		UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
		return userData.getData();
	}
}
