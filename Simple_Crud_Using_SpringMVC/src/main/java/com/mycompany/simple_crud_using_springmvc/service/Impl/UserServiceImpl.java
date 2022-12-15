package com.mycompany.simple_crud_using_springmvc.service.Impl;

import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;
import com.mycompany.simple_crud_using_springmvc.entity.User;
import com.mycompany.simple_crud_using_springmvc.repo.UserRepo;
import com.mycompany.simple_crud_using_springmvc.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveUser(UserDTO dto) {
        if (!repo.existsById(dto.getUserID())) {
            User entity = mapper.map(dto, User.class);
            repo.save(entity);
        } else {
            throw new RuntimeException("User already exists...");
        }
    }

    @Override
    public void deleteUser(String userID) {
        if (repo.existsById(userID)) {
            repo.deleteById(userID);
        } else {
            throw new RuntimeException("Please check the userID.. no such as user...!");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (repo.existsById(dto.getUserID())) {
            User entity = mapper.map(dto, User.class);
            repo.save(entity);
        } else {
            throw new RuntimeException("no such as user to update.. please Check the userID...!");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<UserDTO>>() {

        }.getType());
    }

    @Override
    public UserDTO searchUser(String userID) {
        if (repo.existsById(userID)){
            User user = repo.findById(userID).get();
            return mapper.map(user, UserDTO.class);
        }else {
            throw new RuntimeException("no user for "+userID+"...!");
        }
    }

//    @Override
//    public String generateUserId() {
//        long count = repo.count();
//        String id = "U00-000";
//
//        if (count != 0) {
//            String generateUserId = repo.generateUserId();
//            int tempId = Integer.parseInt(generateUserId.split("-")[1]);
//            tempId += 1;
//            if (tempId < 10) {
//                id = "U00-00" + tempId;
//            } else if (tempId < 100) {
//                id = "U00-0" + tempId;
//            } else if (tempId < 1000) {
//                id = "U00-" + tempId;
//            }
//        } else {
//            id = "U00-000";
//        }
//        return id;
//    }

}
