package com.mycompany.simple_crud_using_springmvc.service;

import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO dto);

    void deleteUser(String userID);

    void updateUser(UserDTO dto);

    List<UserDTO> getAllUsers();

    public UserDTO searchUser(String userID);



//    String generateUserId();
}
