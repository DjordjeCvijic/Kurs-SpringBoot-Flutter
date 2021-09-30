package com.security.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.jdbc.model.Role;
import com.security.jdbc.repository.RoleRepository;

import javassist.NotFoundException;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	// ulazni argument validirati na endpoint-u sa hibernate anotacijom
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	public Role findById(int id) throws NotFoundException {
		return roleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Nije pronađena rola sa id-em:" + id));
	}

	public Role update(Role role) throws NotFoundException {
		if (roleRepository.existsById(role.getRoleId())) {
			return roleRepository.save(role);
		}
		throw new NotFoundException("Nije pronađena rola sa id-em:" + role.getRoleId());
	}

	public void delete(Role role) throws NotFoundException {
		if (roleRepository.existsById(role.getRoleId())) {
			roleRepository.delete(role);
		}
		throw new NotFoundException("Nije pronađena rola sa id-em:" + role.getRoleId());
	}
}
