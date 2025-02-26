package sdmd.highscore;


import static sdmd.OfyService.factory;

import com.googlecode.objectify.Key;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;

import com.googlecode.objectify.annotation.Index;
import sdmd.PersistableEntity;

@Entity
@Cache
public class Highscore extends PersistableEntity {

    public static Key<Highscore> createKey(long id) {
        return Key.create(Highscore.class, id);
    }

    public static Key<Highscore> allocateKey() {
        return factory().allocateId(Highscore.class);
    }

    @Index  // allows for this field to be queried in an ofy query
    private int score;

    @SuppressWarnings("unused")
    private Highscore(){}

    public Highscore(long id, HighscoreForm form) {
        super(id);
        this.updateWithHighscoreForm(form);
    }

    public void updateWithHighscoreForm(HighscoreForm form) {
        this.score = form.getScore();
    }

    public String getWebsafeKey() {
        return createKey(this.getId()).getString();
    }

    public int getScore() {
        return score;
    }
}
