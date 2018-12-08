package bot_wrapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.http.message.BufferedHeader;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MathBot extends TelegramLongPollingBot {
  protected static final String DEBUG_STUB_PATH = "/app/target/classes/banner.txt";

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      Message inp = update.getMessage();
      SendMessage msg = new SendMessage()
          .setChatId(inp.getChatId());
      msg.setText(getDebugStub())
         .enableHtml(true);
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
    return System.getenv().get("BOT_ACCESS_TOKEN");
  }
  public static String getDebugStub() {
    File file = new File(DEBUG_STUB_PATH);
    try {
      FileReader reader = new FileReader(file);
      BufferedReader bfReader = new BufferedReader(reader);
      StringBuffer bfString = new StringBuffer();
      String line;
      while ((line = bfReader.readLine())!=null)
        bfString.append(line+"\n");
      reader.close();
      return bfString.toString();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}