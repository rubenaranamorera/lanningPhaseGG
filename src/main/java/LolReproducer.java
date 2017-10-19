import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import com.mingweisamuel.zyra.spectator.FeaturedGameInfo;

import java.io.File;
import java.io.IOException;

public class LolReproducer {

  private static final String LOL_CLIENT_PATH = "C:/Riot Games/League of Legends/RADS/solutions/lol_game_client_sln/releases/0.0.1.110/deploy/";

  public void reproduceMatch(FeaturedGameInfo currentGameInfo) {

    File dir = new File(LOL_CLIENT_PATH);
    String[] cmd = new String[]{
        dir.getAbsolutePath() + File.separator + "League of Legends.exe",
        "8394",
        "LoLLauncher.exe",
        "\"\"",
        "spectator spectator.na.lol.riotgames.com:80 " + currentGameInfo.observers.encryptionKey + " " + currentGameInfo.gameId + " NA1"};

    try {
      Process proc = Runtime.getRuntime().exec(cmd, null, dir);
      proc.getErrorStream().close();
      proc.getInputStream().close();
      proc.getOutputStream().close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
