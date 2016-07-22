import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 19/07/16.
 */
public class PointCalculatorForRuns implements PointCalculator {
    private Map<Integer, Integer> conditions = new HashMap<Integer, Integer>();

    public int getPoints(Player player) {

        if(isDuck(player.getRuns(), player.isOut())){
            return conditions.get(0);
        }

        int bonusPoints = 0;
        for (Map.Entry<Integer, Integer> condition : conditions.entrySet()){
            int runsEligibleForBonus = condition.getKey();

            if(player.getRuns() >= runsEligibleForBonus && runsEligibleForBonus != 0 ){
                bonusPoints += condition.getValue();
            }
        }
        return bonusPoints;
    }

    private boolean isDuck(int runs, boolean isOut) {
        return isOut && runs == 0;
    }

    public void addCondition(int runs, int applicableBonus) {
        this.conditions.put(runs, applicableBonus);
    }
}
