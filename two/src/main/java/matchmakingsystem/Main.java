package matchMakingSystem;

import java.util.List;

import matchMakingSystem.individual.Individual;
import matchMakingSystem.matchingSystem.MatchingSystem;

/**
 * Hello world!
 *
 */
public class Main {
        public static void main(String[] args) {
                MatchingSystem matcher = new MatchingSystem();

                List<Individual> individuals = loIndividuals();

                Individual individual = individuals.get(0);

                
        }

        private static List<Individual> loIndividuals() {

                Individual individual1 = new Individual(1, "MALE", 25, "Hello, I'm Alice.", "打籃球, 煮菜, 玩遊戲, 寫程式",
                                List.of(100.0f, 200.0f));

                Individual individual2 = new Individual(2, "MALE", 30, "Hi, I'm Bob.", "玩遊戲, 寫程式, 騎腳踏車, 跑步",
                                List.of(80.0f, 180.0f));

                Individual individual3 = new Individual(3, "FEMALE", 53, "Hey, I'm Charlie.", "睡覺, 跑步",
                                List.of(60.0f, 150.0f));

                Individual individual4 = new Individual(4, "MALE", 27, "Hey, I'm Leo.", "打遊戲, 睡覺, 寫程式",
                                List.of(55.0f, 125.0f));

                Individual individual5 = new Individual(5, "FEMALE", 39, "Hey, I'm Marry.", "遛狗, 煮菜, 閱讀, 釣魚",
                                List.of(15.0f, 25.0f));

                List<Individual> individuals = List.of(individual1, individual2, individual3, individual4, individual5);

                return individuals;
        }

}
