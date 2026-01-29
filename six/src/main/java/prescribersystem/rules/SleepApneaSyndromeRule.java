package prescribersystem.rules;

import java.util.List;

import prescribersystem.SymptomEnum;
import prescribersystem.core.Demand;
import prescribersystem.core.PrescribeRule;
import prescribersystem.core.Prescription;

public class SleepApneaSyndromeRule extends PrescribeRule {

    private static final String NAME = "打呼抑制劑";

    private static final String POTENTIAL_DISEASE = "睡眠呼吸中止症";

    private static final List<String> MEDICINES = List.of("清冠一號");

    private static final String USAGE = "將相關藥材裝入茶包裡，使用 500 mL 溫、熱水沖泡悶煮1~3 分鐘後即可飲用。";

    private static final List<SymptomEnum> TARGET_SYMPTOMS = List.of(
            SymptomEnum.SNORE);

    private static final String TARGET_DISEASE = "SleepApneaSyndrome";

    public SleepApneaSyndromeRule(PrescribeRule next) {
        super(next);
    }

    @Override
    protected Prescription prescribe(Demand demand) {
        List<SymptomEnum> symptoms = demand.getSymptoms();

        float height = demand.getHeight();
        float weight = demand.getWeight();

        float bmi = weight / (float) Math.pow(height / 100.0f, 2);

        if (symptoms.containsAll(TARGET_SYMPTOMS) && bmi >= 26) {
            return new Prescription(NAME, POTENTIAL_DISEASE, MEDICINES, USAGE);
        }
        return null;
    }

    @Override
    protected boolean shouldApply(List<String> activeHandlers) {
        return activeHandlers.contains(TARGET_DISEASE);
    }
}