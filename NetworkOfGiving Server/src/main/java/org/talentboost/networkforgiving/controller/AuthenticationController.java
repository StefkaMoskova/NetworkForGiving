package org.talentboost.networkforgiving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talentboost.networkforgiving.model.JwtToken;
import org.talentboost.networkforgiving.model.Login;
import org.talentboost.networkforgiving.model.Register;
import org.talentboost.networkforgiving.model.User;

import org.talentboost.networkforgiving.service.UserService;
import org.talentboost.networkforgiving.utils.JwtTokenUtil;

@RestController
@RequestMapping(path = "authentication")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity login(@RequestBody Login user) {
        User u = userService.getByUsername(user.getUsername());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("User not found"));
        }
        if (!u.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("Invalid password"));
        }

        String token = tokenUtil.generateToken(u);
        return ResponseEntity.ok(new JwtToken(token));
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity register(@RequestBody Register user) {
        User u = userService.getByUsername(user.getUsername());
        if (u != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error("User already exists"));
        } else {
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setAge(user.getAge());
            newUser.setGender(user.getGender());
            newUser.setLocation(user.getLocation());
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());

            newUser = userService.createUser(newUser);
            return ResponseEntity.ok(newUser);
        }
    }
}
