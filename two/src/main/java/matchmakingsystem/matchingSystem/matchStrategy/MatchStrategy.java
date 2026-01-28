package matchMakingSystem.matchingSystem.matchStrategy;

import java.util.List;

import matchMakingSystem.individual.Individual;

public interface MatchStrategy {
	public List<Individual> sorted(Individual individual, List<Individual> candidates);
}
