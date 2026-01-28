package matchMakingSystem.matchingSystem.pickPolicy;

import java.util.List;

import matchMakingSystem.individual.Individual;

public interface PickPolicy {
	public List<Individual> pick(List<Individual> candidates);
}
