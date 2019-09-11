package com.kudria.telegram.bot.sanbox.sandboxtelegrambot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class CommandService {
    public SendMessage findCommand(Update update) {
        String text = update.getMessage().getText();

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());


        message.setText(text);
        return message;
    }
}
