package com.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Application.modals.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// Add custom queries if needed
	User findByUsername(String username);
}

