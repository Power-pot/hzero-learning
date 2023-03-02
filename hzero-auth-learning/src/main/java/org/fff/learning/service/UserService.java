package org.fff.learning.service;

import org.fff.learning.domain.User;

public interface UserService {
    User getUserByUsername(String username);
}
