package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {

    public Bot(String botToken, String botUsername) {
        super(botToken);
        this.botUsername = botUsername;
    }

    private final String botUsername;

    @Override
    public String getBotUsername() { return botUsername; }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();
            try {
                execute(SendMessage.builder().chatId(chatId).text("Эхо: " + text).build());
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) throws Exception {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new Bot(System.getenv("BOT_TOKEN"), System.getenv("BOT_USERNAME")));
        System.out.println("Бот запущен!");
    }
}
