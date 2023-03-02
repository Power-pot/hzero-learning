package org.fff.learning.enums;

import lombok.Getter;

public enum MessageEnum {
    USERNAME_PASSWORD_ERROR("用户名或密码错误!"),
    ACCOUNT_DISABLED("该账户已被禁用，请联系管理员!"),
    ACCOUNT_LOCKED("该账号已被锁定，请联系管理员!"),
    ACCOUNT_EXPIRED("该账号已过期，请联系管理员!"),
    CREDENTIALS_EXPIRED("该账户的登录凭证已过期，请重新登录!");

    @Getter
    private String msg;

    MessageEnum(String msg) {
        this.msg = msg;
    }
}
