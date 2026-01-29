package prescribersystem.rules;

import java.util.List;

import prescribersystem.SymptomEnum;
import prescribersystem.core.Demand;
import prescribersystem.core.PrescribeRule;
import prescribersystem.core.Prescription;

public class AttractiveRule extends PrescribeRule {

    private static final String NAME = "青春抑制劑";

    private static final String POTENTIAL_DISEASE = "有人想你了";

    private static final List<String> MEDICINES = List.of("假鬢角", "臭味");

    private static final String USAGE = "把假鬢角黏在臉的兩側，讓自己異性緣差一點，自然就不會有人想妳了。";

    private static final int TARGET_AGE = 18;

    private static final String TARGET_DISEASE = "Attractive";

    private static final List<SymptomEnum> TARGET_SYMPTOMS = List.of(
            SymptomEnum.SNEEZE);

    public AttractiveRule(PrescribeRule next) {
        super(next);
    }

    @Override
    protected Prescription prescribe(Demand demand) {

        List<SymptomEnum> symptoms = demand.getSymptoms();

        int age = demand.getAge();

        if (symptoms.containsAll(TARGET_SYMPTOMS) && age == TARGET_AGE) {
            return new Prescription(NAME, POTENTIAL_DISEASE, MEDICINES, USAGE);
        }

        return null;
    }

    @Override
    protected boolean shouldApply(List<String> activeHandlers) {
        return activeHandlers.contains(TARGET_DISEASE);
    }
}
