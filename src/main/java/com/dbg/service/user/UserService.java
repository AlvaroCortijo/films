package com.dbg.service.user;

import com.dbg.dto.user.UserDTO;
import com.dbg.model.user.User;

public interface UserService {
	
	UserDTO create(UserDTO user);
	UserDTO findById(Integer id);
	UserDTO transform(User user);
	User transform(UserDTO userDTO);
}
