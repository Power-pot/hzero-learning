package org.fff.learning.controller;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import org.fff.learning.domain.CommonResult;
import org.fff.learning.domain.Oauth2TokenDto;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Map;

@RestController
public class AuthController {

    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Resource
    private TokenEndpoint tokenEndpoint;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CommonResult<Oauth2TokenDto> token(Principal principal, HttpServletRequest request, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken auth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(auth2AccessToken.getValue())
                .refreshToken(auth2AccessToken.getRefreshToken().getValue())
                .expiresIn(auth2AccessToken.getExpiresIn())
                .tokenHead("Bearer ")
                .build();

        return CommonResult.success(oauth2TokenDto);
    }
}
