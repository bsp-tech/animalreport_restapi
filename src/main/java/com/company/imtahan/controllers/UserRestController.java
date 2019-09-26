/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.imtahan.controllers;

import com.company.imtahan.dto.ResponseDTO;
import com.company.imtahan.security.SecurityUtil;
import com.company.imtahan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sarkhanrasullu
 */
@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/private/users/loggedinuser", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> getLoggedInUser() {
        UserProjection loggedInUser = securityUtil.loggedInUser();
        return ResponseEntity.ok(new ResponseDTO(loggedInUser));
    }
    
    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> addAdmin(@RequestBody User user) {
        ResponseDTO result = userService.addUser(user, false);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/public/users", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> add(@RequestBody User user) {
        ResponseDTO result = userService.addUser(user, true);
        return ResponseEntity.ok(result);
    }
    
     @RequestMapping(value = "/admin/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDTO> save(@RequestBody User user, @PathVariable("id") Integer id) {
        ResponseDTO result = userService.save(user, id);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/public/users/sendforgotkey", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> forgotEmail(@RequestBody User user) {
        ResponseDTO result = userService.sendForgotEmail(user);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/public/users/verifyemail", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> verifyEmail(@RequestBody User user) {
        ResponseDTO result = userService.verifyEmail(user);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/public/users/resetpassword", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> resetPassword(@RequestBody User user) {
        System.out.println("email="+user.getEmail());
        ResponseDTO result = userService.resetPassword(user);
        return ResponseEntity.ok(result);
    }

}
