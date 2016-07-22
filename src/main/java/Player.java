import java.util.List;

/**
 * Created by Nikhil on 19/07/16.
 */
public class Player {
    private int runs;
    private PointCalculator pointCalculatorsForRuns;
    private PointCalculator pointCalculatorsForWickets;
    private boolean isOut;
    private int wickets;

    public Player(PointCalculator pointCalculatorsForRuns, PointCalculator pointCalculatorsForWickets){
        this.pointCalculatorsForRuns = pointCalculatorsForRuns;
        this.pointCalculatorsForWickets = pointCalculatorsForWickets;
    }

    public void scoreRuns(int runs) {
        this.runs += runs;
    }

    public int calculatePoints() {
        return calculatePointsForRuns() + calculatePointsForWickets();
    }

    private int calculatePointsForWickets() {
        return this.pointCalculatorsForWickets.getPoints(this);
    }

    private int calculatePointsForRuns() {
        int bonusPoints = runs;
        return bonusPoints + this.pointCalculatorsForRuns.getPoints(this);
    }

    public void out() {
        this.isOut = true;
    }

    public void takeWicket() {
        wickets++;
    }

    public int getRuns() {
        return runs;
    }

    public boolean isOut() {
        return isOut;
    }

    public int getWickets() {
        return wickets;
    }
}
