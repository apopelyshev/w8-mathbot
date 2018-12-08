package bot_wrapper;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MathBot extends TelegramLongPollingBot {
  protected String logoPath = "/app/target/classes/banner.txt";

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      Message inp = update.getMessage();
      SendMessage msg = new SendMessage()
          .setChatId(inp.getChatId());
      try {
        List<String> wiz_logo = getLogo(logoPath);
        String res = String.valueOf((Object) wiz_logo);
        msg.setText(res)
           .enableHtml(true);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
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
  public static List<String> getLogo(String filename) throws IOException {
    return Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
  }
  // public static String whereTheFuckAmI() {
  //   String path = MathBot.class.getProtectionDomain().getCodeSource().getLocation().getPath();
  //   String decodedPath = "";
  //   try {
  //     decodedPath = URLDecoder.decode(path, "UTF-8");
  //   } catch (UnsupportedEncodingException e) {
  //     e.printStackTrace();
  //   }
  //   return decodedPath;
  // }
}