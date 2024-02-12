package com.malimaquintino.javagraphql.services;

import com.malimaquintino.javagraphql.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public void foo() {
        System.out.println("gogogo");
    }

    @Bean
    public void findAll() {
        userRepository.findAll();
    }

}
