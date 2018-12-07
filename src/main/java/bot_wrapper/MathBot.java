package bot_wrapper;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MathBot extends TelegramLongPollingBot {
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      Message inp = update.getMessage();
      SendMessage msg = new SendMessage()
          .setChatId(inp.getChatId())
          .setText(inp.getText());
      try {
        execute(msg);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }
  @Override
  public String getBotUsername() {
    return "w8_mathbot";
  }
  @Override
  public String getBotToken () {
    return System.getProperty("BOT_ACCESS_TOKEN");
  }
}