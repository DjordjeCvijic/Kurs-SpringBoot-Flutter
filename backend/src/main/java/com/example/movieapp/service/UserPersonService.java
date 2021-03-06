package com.example.movieapp.service;

import com.example.movieapp.compositekey.UserPersonRoleKey;
import com.example.movieapp.dto.ForgotPasswordDto;
import com.example.movieapp.dto.ResetPasswordDto;
import com.example.movieapp.dto.UserPersonDto;
import com.example.movieapp.dto.UserPersonInfoDto;
import com.example.movieapp.exception.TokenExpiredException;
import com.example.movieapp.model.*;
import com.example.movieapp.repository.PasswordResetTokenRepository;
import com.example.movieapp.repository.RoleRepository;
import com.example.movieapp.repository.UserPersonRepository;
import com.example.movieapp.repository.UserPersonRoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserPersonService {
    @Autowired
    UserPersonRepository userPersonRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserPersonRoleRepository userPersonRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PasswordResetTokenService passwordResetTokenService;

    @Value("${server.port}")
    int serverPort;

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
        return userPersonRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije prona??ena User sa id-em:" + id));
    }

    public UserPerson updateUserPerson(UserPersonDto userDto) throws NotFoundException {
        if (userPersonRepository.existsById(userDto.getUserPersonId())) {
            userPersonRoleRepository.deleteByUserPerson(getUserPersonById(userDto.getUserPersonId()));
            return saveUserPerson(userDto);

        }
        throw new NotFoundException("Nije prona??en korisnik sa id-em:" + userDto.getUserPersonId());
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
        userPerson.setPassword(passwordEncoder.encode(userPersonDto.getPassword()));
        userPerson.setAddress(userPersonDto.getAddress());
        userPerson.setPhoneNumber(userPersonDto.getPhoneNumber());
        userPerson.setEmail(userPersonDto.getEmail());

        return userPerson;
    }

    public List<UserPerson> getAll() {
        return userPersonRepository.findAll();
    }

    public Optional<UserPerson> getUserPersonByUsername(String username)  {
        return userPersonRepository.findByUsername(username);

    }

    public UserPerson updateUserPersonInfo(UserPersonInfoDto userPersonInfoDto) throws NotFoundException {
        UserPerson userPerson = getUserPersonById(userPersonInfoDto.getUserPersonId());
        if (userPersonInfoDto.getFirstName() != null)
            userPerson.setFirstName(userPersonInfoDto.getFirstName());
        if (userPersonInfoDto.getLastName() != null)
            userPerson.setLastName(userPersonInfoDto.getLastName());
        if (userPersonInfoDto.getAddress() != null)
            userPerson.setAddress(userPersonInfoDto.getAddress());
        if (userPersonInfoDto.getPhoneNumber() != null)
            userPerson.setPhoneNumber(userPersonInfoDto.getPhoneNumber());
        if (userPersonInfoDto.getFirstName() != null)
            userPerson.setFirstName(userPersonInfoDto.getFirstName());
        if (userPersonInfoDto.getUsername() != null)
            userPerson.setUsername(userPersonInfoDto.getUsername());
        userPersonRepository.save(userPerson);
        return userPerson;
    }

    public void forgotPassword(ForgotPasswordDto forgotPasswordDto) throws NotFoundException {
        UserPerson user = userPersonRepository.findByEmail(forgotPasswordDto.getEmail()).orElseThrow(() -> new NotFoundException("Nije prona??en korisnik sa email-om:" + forgotPasswordDto.getEmail()));
        String token = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setUserPerson(user);
        passwordResetToken.setToken(token);
        passwordResetToken.setExpiryDate(LocalDateTime.now().plusDays(1));
        passwordResetTokenRepository.save(passwordResetToken);//stavimo u novu tabelu

        String message = "http://" + InetAddress.getLoopbackAddress().getHostAddress()+":"+serverPort+"/auth/reset-password?token="+token;
        emailService.sendSimpleMessage(user.getEmail(), "MovieApp - resetovanje lozinke", message);
    }

    public UserPerson resetPassword(String token, ResetPasswordDto resetPasswordDto) throws NotFoundException, TokenExpiredException {
        PasswordResetToken passwordResetToken = passwordResetTokenService.findByToken(token);
        passwordResetTokenService.isTokenExpired(token);

        UserPerson user = passwordResetToken.getUserPerson();
        user.setPassword(passwordEncoder.encode(resetPasswordDto.getPassword()));
        userPersonRepository.save(user);

        passwordResetToken.setExpiryDate(LocalDateTime.now());
        passwordResetTokenRepository.save(passwordResetToken);

        return user;
    }
}
