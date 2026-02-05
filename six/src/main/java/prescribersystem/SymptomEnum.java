package prescribersystem;

public enum SymptomEnum {
    SNEEZE("sneeze", 0), HEADACHE("headache", 1), COUGH("cough", 2), SNORE("snore", 3);

    private final String symptom;
    private final int code;

    SymptomEnum(String symptom, int code) {
        this.symptom = symptom;
        this.code = code;
    }

    public String getSymptom() {
        return symptom;
    }

    public int getCode() {
        return code;
    }

    public static SymptomEnum fromString(String text) {
        for (SymptomEnum b : SymptomEnum.values()) {
            if (b.symptom.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unknown symptom: " + text);
    }
}