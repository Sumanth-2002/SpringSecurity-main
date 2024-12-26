package com.ust.SpringSecurity.controller;


import com.ust.SpringSecurity.dto.AuthRequest;
import com.ust.SpringSecurity.model.Event;
import com.ust.SpringSecurity.model.UserInfo;
import com.ust.SpringSecurity.service.EventService;
import com.ust.SpringSecurity.service.JwtService;
import com.ust.SpringSecurity.service.Userservices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private Userservices service;
    @Autowired
    private EventService eventService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/adduser")
    public String addNewUser(@RequestBody  UserInfo user){
        return service.addUser(user);
    }
    @PostMapping("/addEvent")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Event addEvent(@RequestBody Event event){
        return eventService.addEvent(event);
    }

    @GetMapping("/getAllEvents")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Event> getalljobs(){
        return eventService.getAllEvents();
    }

    //login endpoint
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }



}