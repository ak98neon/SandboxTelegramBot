package com.kudria.telegram.bot.sanbox.sandboxtelegrambot.core;

import com.kudria.telegram.bot.sanbox.sandboxtelegrambot.config.TelegramConfiguration;
import com.kudria.telegram.bot.sanbox.sandboxtelegrambot.service.CommandService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
    private TelegramConfiguration configuration;
    private CommandService commandService;

    public Bot(TelegramConfiguration configuration, CommandService commandService) {
        this.configuration = configuration;
        this.commandService = commandService;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage command = commandService.findCommand(update);
            try {
                execute(command);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return configuration.getBotName();
    }

    @Override
    public String getBotToken() {
        return configuration.getToken();
    }
}
