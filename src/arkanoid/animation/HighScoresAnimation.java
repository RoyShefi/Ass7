package arkanoid.animation;

import arkanoid.game.HighScoresTable;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 30/05/2016
 */

public class HighScoresAnimation implements Animation {

    private HighScoresTable scores;
    private KeyboardSensor endKey;
    private boolean stop;

    public HighScoresAnimation(HighScoresTable scores, KeyboardSensor endKey) {
        this.scores = scores;
        this.endKey = endKey;
    }

    /**
     * Displays a num from to countdown.
     * <p/>
     * @param d is the draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(150, 100, "High Scores", 100);
        int y = 200;
        for (int i = 0; i < this.scores.getHighScores().size(); i++) {
            d.drawText(150, y, (i + 1) + ". " + this.scores.getHighScores().get(i).getName(), 25);
            d.drawText(650, y, String.valueOf(this.scores.getHighScores().get(i).getScore()), 25);
            y += 35;
        }
        if (this.endKey.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    /**
     * When to stop.
     * <p/>
     * @return if it reached zero.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}