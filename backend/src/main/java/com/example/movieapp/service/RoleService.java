package com.example.movieapp.service;

import com.example.movieapp.model.Content;
import com.example.movieapp.model.ContentGenre;
import com.example.movieapp.model.Language;
import com.example.movieapp.model.Role;
import com.example.movieapp.repository.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role saveRole(@RequestBody Role requestBody) {
        return roleRepository.save(requestBody);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer id) throws NotFoundException {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađena Rola sa id-em:" + id));
    }


}
