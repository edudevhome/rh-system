package br.com.userapi.services;

import java.util.List;

import br.com.userapi.domain.User;

public interface UserService {

	User findById(Long id);
	List<User> findAll();
}
