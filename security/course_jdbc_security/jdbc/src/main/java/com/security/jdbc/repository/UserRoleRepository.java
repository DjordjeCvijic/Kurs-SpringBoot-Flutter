package com.security.jdbc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.jdbc.model.User;
import com.security.jdbc.model.UserRole;
import com.security.jdbc.model.UserRoleKey;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {

	@Transactional
	@Modifying
	public void deleteByUser(User user);

	public List<UserRole> findByUser(User user);
}
