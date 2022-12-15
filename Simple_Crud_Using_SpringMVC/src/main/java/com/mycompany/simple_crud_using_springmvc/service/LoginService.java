package com.mycompany.simple_crud_using_springmvc.service;


import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;

import java.util.List;

public interface LoginService {

    List<UserDTO> fetchAllUser();


}
