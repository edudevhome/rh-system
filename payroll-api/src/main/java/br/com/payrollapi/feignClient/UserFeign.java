package br.com.payrollapi.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.payrollapi.domain.User;

//Balanceamento de carga de forma automática
//Serviço ja registrado no Eureka Service
//@FeignClient(name = "user-api", url = "http://localhost:8000")

@FeignClient(name = "user-api")
public interface UserFeign {

	@GetMapping(value = "api/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id);
		
	@GetMapping
	public ResponseEntity<List<User>> findAll();
}
