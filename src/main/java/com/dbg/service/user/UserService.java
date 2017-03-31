package com.dbg.service.user;

import com.dbg.dto.user.UserDTO;
import com.dbg.model.user.User;

public interface UserService {
	
	UserDTO create(UserDTO userDTO);
	UserDTO findById(Integer id);
	UserDTO update(UserDTO userDTO);
	void delete(Integer id);
	UserDTO transform(User user);
	User transform(UserDTO userDTO);
}
