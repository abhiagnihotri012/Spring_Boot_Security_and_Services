package com.neosoft.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neosoft.springboot.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
