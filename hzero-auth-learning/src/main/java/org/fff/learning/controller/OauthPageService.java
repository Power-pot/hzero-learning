package org.fff.learning.controller;

import org.apache.commons.lang.StringUtils;
import org.hzero.core.base.BaseConstants;
import org.hzero.oauth.security.constant.LoginType;
import org.hzero.oauth.security.constant.SecurityAttributes;
import org.hzero.oauth.security.util.LoginUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class OauthPageService {

    private static final String SLASH = BaseConstants.Symbol.SLASH;

    public String loginPage(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        String device = request.getParameter("device");
        String type = request.getParameter("type");

        String template = (String) session.getAttribute(LoginUtil.FIELD_TEMPLATE);
        // 登录页面
        String returnPage = "login";
        returnPage = template + SLASH + returnPage;

        // 登录方式
        type = LoginType.match(type) != null ? type : SecurityAttributes.DEFAULT_LOGIN_TYPE.code();
        model.addAttribute(SecurityAttributes.FIELD_LOGIN_TYPE, type);

        String username = (String) session.getAttribute(SecurityAttributes.SECURITY_LOGIN_USERNAME);

        SecurityAttributes.removeSecuritySessionAttribute(session);
        if (StringUtils.isBlank(username)) {
            return returnPage;
        }

        model.addAttribute(SecurityAttributes.SECURITY_LOGIN_USERNAME, username);
        if (LoginType.SMS.code().equals(type)) {
            model.addAttribute(SecurityAttributes.SECURITY_LOGIN_MOBILE, username);
        }

        return returnPage;
    }
}
