package matchMakingSystem.matchingSystem;

import java.util.List;

import matchMakingSystem.matchingSystem.matchStrategy.MatchStrategy;
import matchMakingSystem.matchingSystem.pickPolicy.PickPolicy;
import matchMakingSystem.individual.Individual;

public class MatchingSystem {

    private Individual target;
    private List<Individual> candidates;

    public List<Individual> match(MatchStrategy strategy, PickPolicy policy) {

        List<Individual> sortedCandidates = strategy.sorted(target, candidates);

        return policy.pick(sortedCandidates);
    }

    public void setTarget(Individual target) {
        this.target = target;
    }

    public void setCandidates(List<Individual> candidates) {
        this.candidates = candidates;
    }
}
