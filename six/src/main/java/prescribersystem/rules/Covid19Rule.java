package prescribersystem.rules;

import java.util.List;

import prescribersystem.SymptomEnum;
import prescribersystem.core.Demand;
import prescribersystem.core.PrescribeRule;
import prescribersystem.core.Prescription;

public class Covid19Rule extends PrescribeRule {

    private static final String NAME = "清冠一號";

    private static final String POTENTIAL_DISEASE = "新冠肺炎";

    private static final List<String> MEDICINES = List.of("清冠一號");

    private static final String USAGE = "將相關藥材裝入茶包裡，使用500 mL 溫、熱水沖泡悶煮1~3 分鐘後即可飲用。";

    private static final String TARGET_DISEASE = "COVID-19";

    private static final List<SymptomEnum> TARGET_SYMPTOMS = List.of(
            SymptomEnum.SNEEZE, SymptomEnum.HEADACHE,
            SymptomEnum.COUGH);

    public Covid19Rule(PrescribeRule next) {
        super(next);
    }

    @Override
    protected Prescription prescribe(Demand demand) {
        List<SymptomEnum> symptoms = demand.getSymptoms();

        if (symptoms.containsAll(TARGET_SYMPTOMS)) {
            return new Prescription(NAME, POTENTIAL_DISEASE, MEDICINES, USAGE);
        }

        return null;
    }

    @Override
    protected boolean shouldApply(List<String> activeHandlers) {
        return activeHandlers.contains(TARGET_DISEASE);
    }
}