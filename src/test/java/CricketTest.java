import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil on 19/07/16.
 */
public class CricketTest {
    private Player player;

    @Before
    public void setUp() {
        PointCalculator pointCalculatorForRuns = new PointCalculatorForRuns();
        pointCalculatorForRuns.addCondition(0,-5);
        pointCalculatorForRuns.addCondition(25, 10);
        pointCalculatorForRuns.addCondition(50, 25);
        pointCalculatorForRuns.addCondition(75, 20);
        pointCalculatorForRuns.addCondition(100, 40);

        PointCalculator pointCalculatorForWickets = new PointsCalculatorForWickets();
        pointCalculatorForWickets.addCondition(1,40);
        pointCalculatorForWickets.addCondition(3,20);


        player = new Player(pointCalculatorForRuns, pointCalculatorForWickets);
    }

    @Test
    public void aPlayerEarns1PointForEachRun(){
        player.scoreRuns(10);
        Assert.assertEquals(10, player.calculatePoints());
    }

    @Test
    public void aPlayerEarns1PointForEachRunAndAlsoEarnAdditionalPointsIfRunsGoBeyond25(){
        player.scoreRuns(30);
        Assert.assertEquals(40, player.calculatePoints());
    }

    @Test
    public void aPlayerEarns10PointsFor25runs(){
        player.scoreRuns(25);
        Assert.assertEquals(35, player.calculatePoints());
    }

    @Test
    public void aPlayerLoses5PointsForDuck(){
        player.scoreRuns(0);
        player.out();
        Assert.assertEquals(-5, player.calculatePoints());
    }

    @Test
    public void aPlayerShouldEarn25PointsFor50Runs() {
        player.scoreRuns(50);
        Assert.assertEquals(85, player.calculatePoints());
    }

    @Test
    public void aPlayerShouldEarn20PointsFor75Runs() {
        player.scoreRuns(75);
        Assert.assertEquals(75 + 10 + 25 + 20, player.calculatePoints());
    }

    @Test
    public void aPlayerShouldEarn40PointsFor100Runs() {
        player.scoreRuns(100);
        Assert.assertEquals(100 + 10 + 25 + 20 + 40, player.calculatePoints());
    }

    @Test
    public void aPlayerShouldEarn40PointsForEachWicket(){
        player.takeWicket();
        Assert.assertEquals(40, player.calculatePoints());
    }


    @Test
    public void aPlayerShouldEarn20PointsForAHattrick(){
        player.takeWicket();
        player.takeWicket();
        player.takeWicket();
        Assert.assertEquals(40 + 40 + 40 + 20, player.calculatePoints());
    }

    @Test
    public void aPlayerShouldEarnPointsForBattingAndBowling(){
        player.scoreRuns(2);
        player.takeWicket();
        player.takeWicket();
        player.scoreRuns(23);

        Assert.assertEquals(2+ 40 + 40 + 23 + 10, player.calculatePoints());
    }

}
