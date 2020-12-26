import Utils.Rules;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {

    @Test
    public void updateScore() {
        Score score = new Score();

        Rules.linesRemoved = 10;

        score.updateScore();

        Assert.assertEquals("Nepadidejo teisingai taskai", Rules.linesRemoved * score.getScoreMultiplier(), score.getScore());
    }
}