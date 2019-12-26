package me.lkp111138.dealbot.commands;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import me.lkp111138.dealbot.DealBot;
import me.lkp111138.dealbot.translation.Translation;

public class HowToCommand implements Command {
    @Override
    public void respond(TelegramBot bot, Message msg, String[] args) {
        int sender = msg.from().id();
        if (msg.chat().type() == Chat.Type.Private) {
            SendMessage req = new SendMessage(sender, Translation.get(DealBot.lang(sender)).HOW_TO_PLAY()).parseMode(ParseMode.HTML);
            bot.execute(req);
        } else {
            SendMessage req = new SendMessage(sender, Translation.get(DealBot.lang(msg.chat().id())).HOW_TO_PLAY()).parseMode(ParseMode.HTML);
            bot.execute(req);
        }
    }
}
