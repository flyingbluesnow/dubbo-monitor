package com.handu.open.dubbo.monitor.domain;

import java.io.Serializable;

public class Status implements Serializable {
    private static final long serialVersionUID = -4059755607780265979L;

    private final String level;
    private final String message;
    private final String description;

    public Status(org.apache.dubbo.common.status.Status status) {
        this.level = status.getLevel().name();
        this.message = status.getMessage();
        this.description = status.getDescription();

    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}
