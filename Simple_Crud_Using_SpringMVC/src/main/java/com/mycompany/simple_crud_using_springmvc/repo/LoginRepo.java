package com.mycompany.simple_crud_using_springmvc.repo;

import com.mycompany.simple_crud_using_springmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<User,String> {
}
