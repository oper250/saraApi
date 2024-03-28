package com.jk.saraApi.main.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.saraApi.main.dao.UserDAO;
import com.jk.saraApi.main.dto.CustomUserDetails;
import com.jk.saraApi.main.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! :: " + userId);
        Map<String, Object> rsMap = userDAO.selectUserInfo(userId);

        System.out.println("!@#!@#!@# :: " + rsMap.size());

        UserDTO userDTO = objectMapper.convertValue(rsMap, UserDTO.class);

        if(rsMap != null) {
            return new CustomUserDetails(userDTO);
        }

        return null;
    }
}
