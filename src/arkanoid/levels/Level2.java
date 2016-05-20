package arkanoid.levels;

import arkanoid.geometry.Point;
import arkanoid.geometry.Velocity;
import arkanoid.sprites.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roey Shefi & Oded Thaller
 * @version 1.0
 * @since 17/05/2016
 */
public class Level2 implements LevelInformation {
    private int numOfBalls;

    public Level2 () {
        this.numOfBalls = 1;
    }

    /**
     * Returns the number of balls for the level.
     * <p>
     * @return number of balls for the level.
     */
    public int numberOfBalls() {
        return this.numOfBalls;
    }

    /**
     * See return.
     * <p>
     * @return a List of Velocities for the balls on level2.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        for (int i = 0; i < this.numOfBalls; i++) {
            v.add(new Velocity(1,5));
        }

        return v;
    }

    /**
     * See return.
     * <p>
     * @return Paddle speed.
     */
    public int paddleSpeed() {
        return 6;
    }

    /**
     * See return.
     * <p>
     * @return Paddle width.
     */
    public int paddleWidth() {
        return 300;
    }

    /**
     * Returns the current level name.
     * <p>
     * @return the level name.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * Creates a SpriteCollection of all the sprites of the level, then creates "Back" class.
     * <p>
     * @return the background for level 1.
     */
    public Sprite getBackground() {
        SpriteCollection s = new SpriteCollection();
        s.addSprite(new Block(new Point(0, 0), 800, 600, 0, Color.WHITE));
        s.addSprite(new FullCircle(200,200,60,Color.ORANGE));
        s.addSprite(new FullCircle(200,200,50,Color.YELLOW));



        return new Back(s);
    }

    /**
     * Creates the Blocks of level1.
     * <p>
     * @return the list of starting block of level1.
     */
    public List<Block> blocks() {
        Color [] color = {Color.red,Color.orange,Color.YELLOW,Color.green,Color.blue,Color.pink, Color.CYAN};
        List<Block> b = new ArrayList<>();
        int j =0;
        int flag = 2;
        int r =0;
        for (int k = 0; k < 7; k++) {
            if ( r == 6) { flag = 3;}
            for (int i = 0; i < flag; i++) {
                b.add(new Block(new Point(20+(r * 42.2), 300),42.2 , 20, 1, color[j]));
                r++;
            }
            j++;
        }
        return b;
    }

    /**
     * See return.
     * <p>
     * @return number Of Blocks To Remove.
     */
    public int numberOfBlocksToRemove() {
        return 15;
    }
}
