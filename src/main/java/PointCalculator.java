/**
 * Created by Nikhil on 19/07/16.
 */
public interface PointCalculator {
    int getPoints(Player player);

    void addCondition(int criteria, int applicableBonus);
}
