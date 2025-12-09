package com.microserviceprojects.user_service.Service;

import com.microserviceprojects.user_service.DTO.UserDTO;

public interface UserService {

    UserDTO save(UserDTO userDto);
    UserDTO findById(Integer userId);
    UserDTO findByUserName(String username);
    void deleteById(Integer userId);
    UserDTO updateUser(Integer userId,UserDTO userDTO);
}
