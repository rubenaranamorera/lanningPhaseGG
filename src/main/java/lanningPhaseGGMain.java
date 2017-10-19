import com.mingweisamuel.zyra.spectator.FeaturedGameInfo;

import java.io.IOException;

public class lanningPhaseGGMain {

  public static void main(String[] args) throws IOException {
    MatchPicker matchPicker = new MatchPicker();
    LolReproducer  lolReproducer = new LolReproducer();

    FeaturedGameInfo featuredGameInfo = matchPicker.getGameInfo();
    lolReproducer.reproduceMatch(featuredGameInfo);
  }

}
