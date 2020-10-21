package readability;

public enum GradeLevel {
    KINDERGARTEN(1, 6),
    FIRST_SECOND_GRADE(2, 7),
    THIRD_GRADE(3, 9),
    FOURTH_GRADE( 4, 10),
    FIFTH_GRADE(5, 11),
    SIXTH_GRADE(6, 12),
    SEVENTH_GRADE( 7, 13),
    EIGHTH_GRADE(8, 14),
    NINTH_GRADE( 9, 15),
    TENTH_GRADE( 10, 16),
    ELEVENTH_GRADE( 11, 17),
    TWELFTH_GRADE( 12, 18),
    COLLEGE_STUDENT(13, 24),
    PROFESSOR(14, 25);

    private final int score;
    private final int maxAge;

    GradeLevel(int score, int maxAge) {
        this.score = score;
        this.maxAge = maxAge;
    }

    public static GradeLevel getLevel(double score) {
        score = Math.ceil(score);
        score = score > 14 ? 14.0 : score;
        for (GradeLevel g : values()) {
            if (g.score == (int) score) {
                return g;
            }
        }
        return null;
    }

    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public String toString() {
        return String.format("about %d year olds", maxAge);
    }
}