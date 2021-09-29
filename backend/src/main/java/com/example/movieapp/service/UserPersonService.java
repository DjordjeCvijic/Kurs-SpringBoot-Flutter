package com.example.movieapp.service;

import com.example.movieapp.dto.UserPersonDto;
import com.example.movieapp.model.*;
import com.example.movieapp.repository.RoleRepository;
import com.example.movieapp.repository.UserPersonRepository;
import com.example.movieapp.repository.UserPersonRoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPersonService {
    @Autowired
    UserPersonRepository userPersonRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserPersonRoleRepository userPersonRoleRepository;

    public UserPerson saveUserPerson(UserPersonDto userPersonDto) {
        UserPerson user = userPersonRepository.save(buildUserFromDto(userPersonDto));
        userPersonDto.getRoleIds().forEach(roleId -> {
            UserPersonRoleKey key = new UserPersonRoleKey(userPersonDto.getUserPersonId(), roleId);
            Role role = roleRepository.getById(roleId);
            userPersonRoleRepository.save(new UserPersonRole(key, user, role));
        });


        return user;
    }

    public UserPerson getUserPersonById(Integer id) throws NotFoundException {
        return userPersonRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađena USer sa id-em:" + id));
    }

    public UserPerson updateUserPerson(UserPersonDto userDto) throws NotFoundException {
        if (userPersonRepository.existsById(userDto.getUserPersonId())) {
            userPersonRoleRepository.deleteByUserPerson(getUserPersonById(userDto.getUserPersonId()));
            return saveUserPerson(userDto);

        }
        throw new NotFoundException("Nije pronađen korisnik sa id-em:" + userDto.getUserPersonId());
    }
    public void deleteUserPersonById(int id) throws NotFoundException {
        UserPerson user = getUserPersonById(id);
        user.setActive(false);
        userPersonRepository.save(user);
    }

    private UserPerson buildUserFromDto(UserPersonDto userPersonDto) {
        UserPerson userPerson = new UserPerson();
        if (userPersonDto.getUserPersonId() != null)
            userPerson.setUserPersonId(userPersonDto.getUserPersonId());

        userPerson.setFirstName(userPersonDto.getFirstName());
        userPerson.setLastName(userPersonDto.getLastName());
        userPerson.setUsername(userPersonDto.getUsername());
        userPerson.setPassword(userPersonDto.getPassword());
        userPerson.setAddress(userPersonDto.getAddress());
        userPerson.setPhoneNumber(userPersonDto.getPhoneNumber());
        userPerson.setEmail(userPersonDto.getEmail());

        return userPerson;
    }

    public List<UserPerson> getAll() {
        return userPersonRepository.findAll();
    }

    public Optional<UserPerson> getUserPersonByUsername(String username) {
        return userPersonRepository.findByUsername(username);
    }
}
