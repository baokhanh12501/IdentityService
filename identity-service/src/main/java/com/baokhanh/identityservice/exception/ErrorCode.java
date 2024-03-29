package com.baokhanh.identityservice.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized Error"),
    INVALID_KEY(1001, "Invalid messenger key"),
    USER_EXISTED(1002, "User exited"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters and most 12 characters."),

    INVALID_PASSWORD(1004, "Password must be at least 8 characters")
    ;

    ErrorCode(int code, String messenger) {
        this.code = code;
        this.messenger = messenger;
    }

    private int code;
    private String messenger;

    public int getCode() {
        return code;
    }

    public String getMessenger() {
        return messenger;
    }
}
