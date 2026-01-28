package matchMakingSystem.matchingSystem.matchStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import matchMakingSystem.individual.Individual;

public class HabitBasedMatchStrategy implements MatchStrategy {

	public List<Individual> sorted(Individual individual, List<Individual> candidates) {

		List<Individual> result = new ArrayList<>(candidates);

		result.sort((ind1, ind2) -> {
			int commonCount1 = habitOverlapCount(individual.getHabits(), ind1.getHabits());
			int commonCount2 = habitOverlapCount(individual.getHabits(), ind2.getHabits());

			if (commonCount1 != commonCount2) {
				return Integer.compare(commonCount2, commonCount1);
			}

			return Integer.compare(ind1.getId(), ind2.getId());
		});

		return result;
	}

	private int habitOverlapCount(Set<String> habits1, Set<String> habits2) {
		Set<String> intersection = new HashSet<>(habits1);

		intersection.retainAll(habits2);
		return intersection.size();
	}
}
