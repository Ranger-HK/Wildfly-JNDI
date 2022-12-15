package com.mycompany.simple_crud_using_springmvc.service.Impl;

import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;
import com.mycompany.simple_crud_using_springmvc.entity.User;
import com.mycompany.simple_crud_using_springmvc.repo.LoginRepo;
import com.mycompany.simple_crud_using_springmvc.service.LoginService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDTO> fetchAllUser() {
        List<User> all = loginRepo.findAll();
        return modelMapper.map(all, new TypeToken<List<UserDTO>>() {

        }.getType());

    }


}
