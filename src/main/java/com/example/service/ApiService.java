package com.example.service;

import java.util.List;

import com.example.domain.User;

public interface ApiService {
	List<User> getUsers(Integer limit);
}
