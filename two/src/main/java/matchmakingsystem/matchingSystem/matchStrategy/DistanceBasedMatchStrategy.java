package matchMakingSystem.matchingSystem.matchStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import matchMakingSystem.individual.Individual;

public class DistanceBasedMatchStrategy implements MatchStrategy {

    public List<Individual> sorted(Individual individual, List<Individual> candidates) {

        List<Individual> result = new ArrayList<>(candidates);

        result.sort(new Comparator<Individual>() {
            @Override
            public int compare(Individual ind1, Individual ind2) {
                float dist1 = calculateDistance(individual, ind1);
                float dist2 = calculateDistance(individual, ind2);

                int comparison = Float.compare(dist1, dist2);

                if (comparison != 0) {
                    return comparison;
                }

                return Integer.compare(ind1.getId(), ind2.getId());
            }
        });

        return result;
    }

    private float calculateDistance(Individual ind1, Individual ind2) {
        List<Float> coord1 = ind1.getCoord();
        List<Float> coord2 = ind2.getCoord();

        float dx = coord1.get(0) - coord2.get(0);
        float dy = coord1.get(1) - coord2.get(1);

        return dx * dx + dy * dy;
    }
}
