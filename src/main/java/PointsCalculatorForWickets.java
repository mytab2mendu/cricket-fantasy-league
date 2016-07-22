import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhil on 19/07/16.
 */
public class PointsCalculatorForWickets implements PointCalculator {
    private Map<Integer, Integer> conditions = new HashMap<Integer, Integer>();

    public int getPoints(Player player) {
        int bonusPoints = 0;

        for (Map.Entry<Integer, Integer> condition : conditions.entrySet()) {
            if (player.getWickets() >= condition.getKey()) {
                bonusPoints += (player.getWickets() / condition.getKey()) * condition.getValue();
            }
        }
        return bonusPoints;
    }

    public void addCondition(int criteria, int applicableBonus) {
        this.conditions.put(criteria, applicableBonus);
    }
}
