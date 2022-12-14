package br.com.userapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.userapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
