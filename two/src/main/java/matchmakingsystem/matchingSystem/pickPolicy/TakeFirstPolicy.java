package matchMakingSystem.matchingSystem.pickPolicy;

import java.util.List;
import matchMakingSystem.individual.Individual;

public class TakeFirstPolicy implements PickPolicy {
    @Override
    public List<Individual> pick(List<Individual> candidates) {
        return candidates.subList(0, 1);
    }
    
}
