package br.com.strfelix.finora_spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.strfelix.finora_spring.model.Preferences;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateUser(@RequestBody User user){
        userService.CreateUser(user);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public User AuthenticateUser(@RequestBody Map<String, String> body){
        return userService.AuthenticateUser(body.get("email"), body.get("plainPassword"));
    }

    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateUser(@RequestBody User user, @PathVariable Long userId){
        userService.UpdateUserById(user, userId);
    }

    @PutMapping("/preferences/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdateUserPreferences(@RequestBody Preferences preferences, @PathVariable Long userId){
        userService.UpdateUserPreferences(preferences, userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteUser(@PathVariable Long userId){
        userService.DeleteUserById(userId);
    }
}
