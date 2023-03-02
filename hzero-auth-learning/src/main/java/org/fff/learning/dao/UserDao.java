package org.fff.learning.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fff.learning.domain.User;

@Mapper
public interface UserDao {

    User getUserByUsername(@Param("username") String username);
}
