package com.security.jdbcsecurityproject.service;

import com.security.jdbcsecurityproject.dto.UserPersonDto;
import com.security.jdbcsecurityproject.model.Role;
import com.security.jdbcsecurityproject.model.UserPerson;
import com.security.jdbcsecurityproject.model.UserRole;
import com.security.jdbcsecurityproject.model.UserRoleId;
import com.security.jdbcsecurityproject.repository.RoleRepository;
import com.security.jdbcsecurityproject.repository.UserPersonRepository;
import com.security.jdbcsecurityproject.repository.UserRoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserPersonService {
    @Autowired
    UserPersonRepository userPersonRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    RoleRepository roleRepository;

    public UserPerson saveUserPerson(UserPersonDto userPersonDto){
        UserPerson user=userPersonRepository.save(buildUserFromDto(userPersonDto));
        userPersonDto.getRoleIds().forEach(roleId->{
            UserRoleId key=new UserRoleId(userPersonDto.getUserId(),roleId);
            Role role=roleRepository.getById(roleId);
            userRoleRepository.save(new UserRole(key,user,role));
        });


        return user;
    }
    public UserPerson findById(Integer id){
        return userPersonRepository.findById(id).get();
    }

    public UserPerson update(UserPersonDto userDto) throws NotFoundException {
        if (userPersonRepository.existsById(userDto.getUserId())) {
            userRoleRepository.deleteByUserPerson(findById(userDto.getUserId()));
            UserPerson user = userPersonRepository.save(buildUserFromDto(userDto));
            userDto.getRoleIds().forEach(roleId -> {
                UserRoleId key = new UserRoleId(user.getUserId(), roleId);
                Role role = roleRepository.getById(roleId);
                userRoleRepository.save(new UserRole(key, user, role));
            });

            return user;
        }
        throw new NotFoundException("Nije pronađen korisnik sa id-em:" + userDto.getUserId());
    }

    public void delete(int id) throws NotFoundException {
        UserPerson user = findById(id);
        user.setActive(false);
        userPersonRepository.save(user);
    }
    private UserPerson buildUserFromDto(UserPersonDto userPersonDto) {
        UserPerson userPerson=new UserPerson();
        if(userPersonDto.getUserId()!=null)
            userPerson.setUserId(userPersonDto.getUserId());
        userPerson.setFirstName(userPersonDto.getFirstName());
        userPerson.setLastName(userPersonDto.getLastName());
        userPerson.setUsername(userPersonDto.getUsername());
        userPerson.setPassword(userPersonDto.getPassword());

        return userPerson;

    }


    public Optional<UserPerson> findUserByUsername(String username) {
        return userPersonRepository.findByUsername(username);
    }
}
