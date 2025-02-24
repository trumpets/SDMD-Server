package sdmd.highscore;

public class HighscoreForm {

    private int score;

    @SuppressWarnings("unused")
    private HighscoreForm() {
    }

    public HighscoreForm(int score) {
        super();
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
