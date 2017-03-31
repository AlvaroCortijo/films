package com.dbg.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbg.dto.user.UserDTO;
import com.dbg.service.user.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserDTO create(@RequestBody UserDTO userDTO){
		return userService.create(userDTO);
	}
}
