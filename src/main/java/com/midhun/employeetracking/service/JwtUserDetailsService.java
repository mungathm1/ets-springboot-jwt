package com.midhun.employeetracking.service;

import com.midhun.employeetracking.dto.UserInfoDto;
import com.midhun.employeetracking.model.UserInfo;
import com.midhun.employeetracking.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        if(userInfo == null) {
            throw new UsernameNotFoundException("User not found with username: " +username);
        }
        return new User(userInfo.getUsername(), userInfo.getPassword(),new ArrayList<>());
    }

    public UserInfo addUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userInfoDto.getUsername());
        userInfo.setPassword(bcryptEncoder.encode(userInfoDto.getPassword()));
        return userInfoRepository.save(userInfo);
    }

    public UserInfo getProfile(String username) {
        return userInfoRepository.findByUsername(username);
    }


}
