import Utils.Rules;

import java.awt.*;

public class Score {
    private int score;
    private int scoreMultiplier;

    public Score(){
        score = 0;
        scoreMultiplier = 100;
    }

    public void draw(Graphics gfx){
        gfx.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        gfx.drawString("SCORE: " + score, Rules.SCORE_POINT_X, Rules.SCORE_POINT_Y);
    }

    public void updateScore(){
        score = scoreMultiplier*Rules.linesRemoved;
    }

    public int getScoreMultiplier(){
        return scoreMultiplier;
    }

    public int getScore(){
        return score;
    }
}
