package org.fff.learning.enums;

import lombok.Getter;

public enum RedisEnum {

    RESOURCE_ROLES_MAP("AUTH:RESOURCE_ROLES_MAP");

    @Getter
    private String msg;

    RedisEnum(String msg) {
        this.msg = msg;
    }
}
