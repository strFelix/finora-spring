package br.com.strfelix.finora_spring.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.strfelix.finora_spring.Utils.PasswordHasher;
import br.com.strfelix.finora_spring.model.Preferences;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    public void CreateUser(User user){
        PasswordHasher passwordHasher = new PasswordHasher();
        String hashedPassword = passwordHasher.hashPassword(user.getPlainPassword());
        user.setPasswordHash(hashedPassword);
        _userRepository.save(user);
    }

    public User AuthenticateUser(String email, String plainPassword){
        Optional<User> optionalUser = _userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            PasswordHasher passwordHasher = new PasswordHasher();
            if(passwordHasher.checkPassword(plainPassword, optionalUser.get().getPasswordHash())){
                optionalUser.get().setLastLoginDate(LocalDateTime.now());
                _userRepository.save(optionalUser.get());
                return optionalUser.get();
            }
            else {
                throw new SecurityException("Invalid email or password.");
            }
        }
        else{
            throw new EntityNotFoundException("Invalid email or password.");
        }
    }

    public User FindUserById(Long id){
        Optional<User> optionalUser = _userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw new EntityNotFoundException("User not found.");
        }
    }

    public void UpdateUserById(User user){
        FindUserById(user.getId());
        _userRepository.save(user);
    }

    public void UpdateUserPreferences(Preferences preferences, Long userId){
        User user = FindUserById(userId);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(preferences);
            user.setPreferencesJson(json);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        _userRepository.save(user);
    }

    public void DeleteUserById(Long id){
        FindUserById(id);
        _userRepository.deleteById(id);
    }
}
