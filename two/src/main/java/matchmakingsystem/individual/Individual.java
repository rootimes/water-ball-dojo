package matchMakingSystem.individual;

import java.util.List;
import java.util.Set;

public class Individual {

    private int id;
    private Gender gender;
    private int age;
    private String intro;
    private Set<String> habits;
    private List<Float> coord;

    public Individual(int id, String gender, int age, String intro, String habitString, List<Float> coord) {
        if (!validateId(id))
            throw new IllegalArgumentException("Invalid id: " + id);
        if (!validateGender(gender))
            throw new IllegalArgumentException("Invalid gender");
        if (!validateAge(age))
            throw new IllegalArgumentException("Invalid age: " + age);
        if (!validateIntro(intro))
            throw new IllegalArgumentException("Invalid intro");
        if (!validateCoord(coord))
            throw new IllegalArgumentException("Invalid coord");

        this.id = id;
        this.gender = Gender.fromString(gender);
        this.age = age;
        this.intro = intro;
        this.habits = parseHabits(habitString);
        this.coord = coord;
    }

    public int getId() {
        return id;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public String getHabitSyString() {
        return String.join(",", habits);
    }

    public List<Float> getCoord() {
        return coord;
    }

    private boolean validateId(int id) {
        return id > 0;
    }

    private boolean validateGender(String genderString) {
        return genderString != null;
    }

    private boolean validateAge(int age) {
        return age >= 18;
    }

    private boolean validateIntro(String intro) {
        return intro != null && intro.length() <= 200;
    }

    private boolean validateCoord(List<Float> coord) {
        return coord != null
                && coord.size() == 2
                && coord.get(0) != null
                && coord.get(1) != null;
    }

    private boolean validateHabits(String habitName) {
        return habitName != null && habitName.length() > 0 && habitName.length() <= 10;
    }

    private Set<String> parseHabits(String habitString) {
        Set<String> habits = new java.util.HashSet<>();

        if (habitString == null || habitString.isBlank()) {
            return habits;
        }

        for (String raw : habitString.split(",")) {
            String habitName = raw.trim();
            if (!validateHabits(habitName)) {
                throw new IllegalArgumentException("Invalid habit: " + habitName);
            }
            habits.add(habitName);
        }

        return habits;
    }
}