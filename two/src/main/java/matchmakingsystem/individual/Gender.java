package matchMakingSystem.individual;

public enum Gender {
	MALE("MALE"), FEMALE("FEMALE");

	private final String value;

	Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Gender fromString(String input) {
		switch (input.trim().toUpperCase()) {
			case "MALE" :
				return MALE;
			case "FEMALE" :
				return FEMALE;
			default :
				throw new IllegalArgumentException("Invalid gender: " + input);
		}
	}
}
