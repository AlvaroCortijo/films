package com.dbg.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbg.dto.user.UserDTO;
import com.dbg.service.user.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserDTO userDTO){
		return userService.create(userDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO findById(@PathVariable("id") Integer id){
		return userService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserDTO> findAll(){
		return userService.findAll();
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public UserDTO update(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO){
		return userService.update(userDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id){
		userService.delete(id);
	}
}
