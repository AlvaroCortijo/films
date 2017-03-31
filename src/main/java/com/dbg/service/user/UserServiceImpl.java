package com.dbg.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbg.dao.user.UserDao;
import com.dbg.dto.user.UserDTO;
import com.dbg.model.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDTO create(UserDTO userDTO) {
		final User user = transform(userDTO);
		return transform(userDao.save(user));
	}
	
	@Override
	public UserDTO findById(Integer id) {
			return transform(userDao.findOne(id));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		final User user = transform(userDTO);
		return transform(userDao.save(user));
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}
	
	@Override
	public UserDTO transform(User user) {
		final UserDTO userDTO = new UserDTO(user.getId(), user.getName());
		return userDTO;
	}
	@Override
	public User transform(UserDTO userDTO) {
		final User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		return user;
	}

}
