package org.fff.learning.service.impl;

import org.fff.learning.dao.UserDao;
import org.fff.learning.domain.User;
import org.fff.learning.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
