package com.kudria.telegram.bot.sanbox.sandboxtelegrambot.log;

public enum BotLogs {
    ERROR_TELEGRAM(1, "Request not send {}");

    private int code;
    private String message;

    BotLogs(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
