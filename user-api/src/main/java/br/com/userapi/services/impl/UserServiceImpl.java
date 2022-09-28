package br.com.userapi.services.impl;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.userapi.domain.User;
import br.com.userapi.repositories.UserRepository;
import br.com.userapi.services.UserService;
import br.com.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final Environment environment;
	
	@Override
	public User findById(Long id) {
		log.info("USER_SERVICE ::: Get request on " + environment.getProperty("local.server.port") + " port");
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
