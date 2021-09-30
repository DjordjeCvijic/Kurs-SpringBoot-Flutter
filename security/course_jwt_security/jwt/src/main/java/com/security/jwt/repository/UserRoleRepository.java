package com.security.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.security.jwt.model.User;
import com.security.jwt.model.UserRole;
import com.security.jwt.model.UserRoleKey;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey> {

	@Transactional
	@Modifying
	public void deleteByUser(User user);

	public List<UserRole> findByUser(User user);
}
