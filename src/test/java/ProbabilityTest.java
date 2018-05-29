import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {

    public static final double PROBABILITY_Of_TAIL = 0.5;

    @Test
    public void shouldRepresentTheChanceOfGettingTail() {
        Probability probability = new Probability(PROBABILITY_Of_TAIL);

        assertEquals(probability, new Probability(0.5));
    }
}
