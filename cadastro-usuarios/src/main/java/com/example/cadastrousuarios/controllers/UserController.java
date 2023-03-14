package com.example.cadastrousuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastrousuarios.models.User;
import com.example.cadastrousuarios.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<User> getUserById(@PathVariable Long codigo) {
        try {
            User user = userService.findById(codigo);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{codigo}")
    public User updateUser(@PathVariable Long codigo, @RequestBody User user) {
        user.setCodigo(codigo);
        return userService.save(user);
    }

    @DeleteMapping("/{codigo}")
    public void deleteUser(@PathVariable Long codigo) {
        userService.deleteById(codigo);
    }
}
