package org.fff.learning.service;

import cn.hutool.core.collection.CollUtil;
import org.fff.learning.domain.SecurityUser;
import org.fff.learning.domain.UserDTO;
import org.fff.learning.enums.MessageEnum;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private List<UserDTO> userList;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDTO(1L,"macro", password,1, CollUtil.toList("ADMIN")));
        userList.add(new UserDTO(2L,"andy", password,1, CollUtil.toList("TEST")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDTO> users = this.userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if(CollUtil.isEmpty(users)) {
            throw new UsernameNotFoundException(MessageEnum.USERNAME_PASSWORD_ERROR.getMsg());
        }

        SecurityUser securityUser = new SecurityUser(users.get(0));
        if(!securityUser.getEnabled()) {
            throw new DisabledException(MessageEnum.ACCOUNT_DISABLED.getMsg());
        } else if(!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageEnum.ACCOUNT_LOCKED.getMsg());
        } else if(!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageEnum.ACCOUNT_EXPIRED.getMsg());
        } else if(!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageEnum.CREDENTIALS_EXPIRED.getMsg());
        }
        return securityUser;
    }
}
