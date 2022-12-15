package com.mycompany.simple_crud_using_springmvc.controller;

import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;
import com.mycompany.simple_crud_using_springmvc.service.UserService;
import com.mycompany.simple_crud_using_springmvc.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

  /*  @Autowired
    Encryption en;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@ModelAttribute UserDTO user) {
        try {
            String passwordEncrypt = en.encrypt(user.getPassword());

            userService.saveUser(new UserDTO(user.getUserID(), user.getUserName(), user.getAddress(), user.getEmail(), user.getContact(), passwordEncrypt, LocalDate.now().toString(), " "));

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return new ResponseUtil(200, "Ok", null);
    }*/

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUser() {
        return new ResponseUtil(200, "Ok", userService.getAllUsers());

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@ModelAttribute UserDTO user) {

        userService.saveUser(new UserDTO(user.getUserID(), user.getUserName(), user.getAddress(), user.getEmail(), user.getContact(), user.getPassword(), LocalDate.now().toString(), " "));
        return new ResponseUtil(200, "Ok", null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO user) {
        UserDTO userDTO = userService.searchUser(user.getUserID());
        userService.updateUser(new UserDTO(user.getUserID(), user.getUserName(), user.getAddress(), user.getEmail(), user.getContact(), userDTO.getPassword(), userDTO.getCreateTime(), LocalDateTime.now().toString()));
        return new ResponseUtil(200, "Ok", null);
    }

    @DeleteMapping(params = {"userID"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String userID) {
        userService.deleteUser(userID);
        return new ResponseUtil(200, "Ok", null);
    }

    @GetMapping(path = "/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@PathVariable String userID) {
        return new ResponseUtil(200, "Ok", userService.searchUser(userID));
    }


//    @GetMapping(value = "/generate",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseUtil getGenerateID() {
//        return new ResponseUtil(200, "Ok", userService.generateUserId());
//    }


}
