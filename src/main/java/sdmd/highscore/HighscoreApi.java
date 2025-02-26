package sdmd.highscore;

import static sdmd.OfyService.ofy;

import java.util.Comparator;
import java.util.List;

import sdmd.Constants;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;

@Api(name = "highscores", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = { Constants.WEB_CLIENT_ID,
        Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID,
        Constants.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE }, description = "highscores api")
public class HighscoreApi {

    @ApiMethod(name = "createHighscore", path = "score", httpMethod = HttpMethod.POST)
    public Highscore createHighscore(final HighscoreForm form) {

        // Allocate Id first, in order to make the transaction idempotent.
        final Key<Highscore> key = Highscore.allocateKey();
        Highscore highscore = new Highscore(key.getId(), form);

        ofy().save().entity(highscore).now();

        return highscore;
    }

    @ApiMethod(name = "getHighscores", path = "score", httpMethod = HttpMethod.GET)
    public List<Highscore> getHighscores() {
        return ofy().load()
                .type(Highscore.class)
                .order("-score")  // Order by score descending
                .limit(10)        // Get only 10 results
                .list();
    }
}
