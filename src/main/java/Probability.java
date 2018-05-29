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
}
