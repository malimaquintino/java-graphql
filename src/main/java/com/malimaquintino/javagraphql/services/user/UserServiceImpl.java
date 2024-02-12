package com.malimaquintino.javagraphql.services.user;

import com.malimaquintino.javagraphql.dto.UserInputDto;
import com.malimaquintino.javagraphql.model.User;
import com.malimaquintino.javagraphql.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(UserInputDto userInputDto) {
        return userRepository.save(User.parseFromDto(userInputDto));
    }

}
