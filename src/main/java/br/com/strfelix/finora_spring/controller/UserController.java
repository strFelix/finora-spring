package br.com.strfelix.finora_spring.controller;

import br.com.strfelix.finora_spring.model.Preferences;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User GetUserById(@PathVariable Long userId){
        return userService.FindUserById(userId);
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
