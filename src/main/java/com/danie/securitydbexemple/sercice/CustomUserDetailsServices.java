package com.danie.securitydbexemple.sercice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danie.securitydbexemple.model.CustomUserDetails;
import com.danie.securitydbexemple.model.Users;
import com.danie.securitydbexemple.repository.UsersRepository;

@Service
public class CustomUserDetailsServices implements UserDetailsService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findAllByName(username);
		
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User name not found"));
//		optionalUsers.ifPresent(users ->new CustomUserDetails(users));
		return optionalUsers.map(CustomUserDetails::new).get();
		
		
	}

}
