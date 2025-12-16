package matchmaking.individual;

public enum Gender {
    MALE('M'),
    FEMALE('F'),
    UNKNOWN('U');

    private final char value;

    Gender(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}