package com.malimaquintino.javagraphql.services.user;

import com.malimaquintino.javagraphql.dto.UserInputDto;
import com.malimaquintino.javagraphql.model.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();
    User findById(Long id);
    User save(UserInputDto userInputDto);
}
