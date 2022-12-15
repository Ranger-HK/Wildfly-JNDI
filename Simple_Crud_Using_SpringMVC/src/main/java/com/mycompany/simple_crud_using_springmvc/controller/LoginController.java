package com.mycompany.simple_crud_using_springmvc.controller;

import com.mycompany.simple_crud_using_springmvc.dto.UserDTO;
import com.mycompany.simple_crud_using_springmvc.service.LoginService;
import com.mycompany.simple_crud_using_springmvc.util.Encryption;
import com.mycompany.simple_crud_using_springmvc.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;

@RestController
@RequestMapping("login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    Encryption encryption;

    @PostMapping(params = {"userName", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil userLogin(@RequestParam String userName, String password) {

        for (UserDTO dto : loginService.fetchAllUser()) {
            String passwordEncrypt = dto.getPassword();
//            String passwordDecrypt = null;
            try {
                String passwordDecrypt = encryption.decrypt(passwordEncrypt);

                if (dto.getUserName().equalsIgnoreCase(userName) & passwordDecrypt.equalsIgnoreCase(password)) {
                    return new ResponseUtil(200, "Ok", null);
                }
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }

        }

        return new ResponseUtil(400, "error", null);
    }
}



   /* @PostMapping(params = {"userName", "password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil userLogin(@RequestParam String userName, String password) {

        for (UserDTO dto : loginService.fetchAllUser()) {
            if (dto.getUserName().equalsIgnoreCase(userName) & dto.getPassword().equalsIgnoreCase(password)) {
                return new ResponseUtil(200, "Ok", null);
            }
        }

        return new ResponseUtil(400, "error", null);
    }
}*/
