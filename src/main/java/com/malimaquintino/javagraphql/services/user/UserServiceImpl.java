package com.malimaquintino.javagraphql.services.user;

import com.malimaquintino.javagraphql.dto.UserInputDto;
import com.malimaquintino.javagraphql.model.User;
import com.malimaquintino.javagraphql.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find User");
        }
    }

    @Override
    public User findById(Long id) {
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find User");
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on find User");
        }
    }

    @Override
    public User save(UserInputDto userInputDto) {
        try {
            return userRepository.save(User.parseFromDto(userInputDto));
        } catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
            throw new RuntimeException("Error on save User");
        }
    }

}
