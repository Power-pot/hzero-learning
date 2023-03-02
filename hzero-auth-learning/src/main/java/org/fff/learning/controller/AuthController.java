package org.fff.learning.controller;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import org.fff.learning.domain.User;
import org.fff.learning.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AuthController {

    @Resource
    private UserService userService;

    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @GetMapping("/hello")
    public String hello() {
        User user = userService.getUserByUsername("Eugene");
        return user.getUsername();
    }
}
