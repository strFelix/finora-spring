package br.com.strfelix.finora_spring.service;

import java.time.LocalDateTime;
import java.util.Optional;

import br.com.strfelix.finora_spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.strfelix.finora_spring.utils.PasswordHasher;
import br.com.strfelix.finora_spring.model.Preferences;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void CreateUser(User user){
        PasswordHasher passwordHasher = new PasswordHasher();
        String hashedPassword = passwordHasher.hashPassword(user.getPlainPassword());
        user.setPasswordHash(hashedPassword);
        userRepository.save(user);
    }

    public User AuthenticateUser(String email, String plainPassword){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            PasswordHasher passwordHasher = new PasswordHasher();
            if(passwordHasher.checkPassword(plainPassword, optionalUser.get().getPasswordHash())){
                optionalUser.get().setLastLoginDate(LocalDateTime.now());
                userRepository.save(optionalUser.get());
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

    public User FindUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    public void UpdateUserById(User user, Long userId){
        User existing = FindUserById(userId);
        userMapper.updateUserFromDto(user, existing);
        userRepository.save(existing);
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
        userRepository.save(user);
    }

    public void DeleteUserById(Long userId){
        FindUserById(userId);
        userRepository.deleteById(userId);
    }
}
