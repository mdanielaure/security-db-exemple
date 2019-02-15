package com.danie.securitydbexemple.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danie.securitydbexemple.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

Optional<Users>  findAllByName(String username);

}
