package com.family.circle.api.common.enumeration;

import lombok.Getter;

@Getter
public enum ChatMessageType {
    TEXT(0),
    IMAGE(1),
    ;

    private Integer type;

    ChatMessageType(Integer type) {
        this.type = type;
    }
}
