package org.fff.learning.controller;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @GetMapping("/hello")
    public String hello() {
        return "hello! world!";
    }
}
