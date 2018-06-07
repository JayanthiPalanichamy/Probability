public class Probability {
    private final double probabilityValue;

    public Probability(double probabilityValue) {
        this.probabilityValue = probabilityValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.probabilityValue, probabilityValue) == 0;
    }

    public Probability not() {
        return new Probability(1 - probabilityValue);
    }

    public Probability and(Probability other) {
        return new Probability(probabilityValue * other.probabilityValue);
    }

    public Probability or(Probability other) {
        return not().and(other.not()).not();
    }

    @Override
    public String toString() {
        return "Probability{" +
                "probabilityValue=" + probabilityValue +
                '}';
    }
}
