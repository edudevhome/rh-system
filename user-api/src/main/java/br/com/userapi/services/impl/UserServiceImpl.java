package br.com.userapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.userapi.domain.User;
import br.com.userapi.repositories.UserRepository;
import br.com.userapi.services.UserService;
import br.com.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
