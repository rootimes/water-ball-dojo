package matchMakingSystem.matchingSystem.pickPolicy;

import java.util.List;
import matchMakingSystem.individual.Individual;

public class TakeLastPolicy implements PickPolicy {
    @Override
    public List<Individual> pick(List<Individual> candidates) {
        return candidates.subList(candidates.size() - 1, candidates.size());
    }

}
