package com.midhun.employeetracking.controller;

import com.midhun.employeetracking.config.JwtTokenUtil;
import com.midhun.employeetracking.dto.UserInfoDto;
import com.midhun.employeetracking.model.JwtRequest;
import com.midhun.employeetracking.model.JwtResponse;
import com.midhun.employeetracking.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public ResponseEntity<?> createJwtToken(@RequestBody JwtRequest jwtRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ResponseEntity<?> addUser(@RequestBody UserInfoDto userDetails) {
        return ResponseEntity.ok(jwtUserDetailsService.addUser(userDetails));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{username}")
    public ResponseEntity<?> getUser(@PathVariable("username") String username) {
        return ResponseEntity.ok(jwtUserDetailsService.getProfile(username));
    }


}
