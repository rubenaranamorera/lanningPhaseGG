import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.spectator.FeaturedGameInfo;
import com.mingweisamuel.zyra.spectator.FeaturedGames;

import java.io.IOException;

public class MatchPicker {

  // Login to: https://developer.riotgames.com/ 
  public static final String API_KEY = "RGAPI-bf91767d-05c7-4a45-8076-1d1e990a842b";

  public FeaturedGameInfo getGameInfo() throws IOException {

    try (RiotApi api = RiotApi.builder(API_KEY).build()) {

      FeaturedGames featuredGames = api.spectator.getFeaturedGames(Region.NA);
      System.out.println(featuredGames.gameList.size());


      FeaturedGameInfo lastFeaturedGame = null;
      for (FeaturedGameInfo featuredGameInfo: featuredGames.gameList) {
        if (lastFeaturedGame == null || featuredGameInfo.gameLength < lastFeaturedGame.gameLength ){
          lastFeaturedGame = featuredGameInfo;
        }
      }

      return lastFeaturedGame;
    }
  }
}
