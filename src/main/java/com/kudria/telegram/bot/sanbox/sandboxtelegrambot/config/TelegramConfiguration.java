package com.kudria.telegram.bot.sanbox.sandboxtelegrambot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramConfiguration {
    @Value("${telegram.bot_name}")
    private String botName;

    @Value("${TELEGRAM_TOKEN}")
    private String token;

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
