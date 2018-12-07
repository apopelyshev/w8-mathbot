package bot_wrapper;

import org.telegram.telegrambots.meta.TelegramBotsApi;
// import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.ApiContextInitializer;

public class Main {
  public static void main (String[] args) {
    ApiContextInitializer.init();

    TelegramBotsApi botsApi = new TelegramBotsApi();

    System.out.print("EVERYTHING SEEMS TO BE ALRIGHT AT THIS MOMENT!");
    // try {
    //   botsApi.registerBot(new MathBot());
    // } catch (TelegramApiRequestException e) {
    //   e.printStackTrace();
    // }
  }
}