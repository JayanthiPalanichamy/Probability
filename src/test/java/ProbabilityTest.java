import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ProbabilityTest {

    public static final double PROBABILITY_OF_TAIL = 0.5;
    public static final double PROBABILITY_OF_NOT_GETTING_TAIL = 1 - PROBABILITY_OF_TAIL;

    private Probability a;
    private Probability b;
    private Probability c;

    @Before
    public void setUp() {
        a = new Probability(0.2);
        b = new Probability(0.2);
        c = new Probability(0.2);
    }

    @Test
    public void shouldRepresentTheChanceOfGettingTail() {
        Probability probability = new Probability(PROBABILITY_OF_TAIL);

        assertEquals(probability, new Probability(0.5));
    }

    @Test
    public void checkEqualsMethodIsSymmetric() {
        assertEquals(a.equals(b), b.equals(a));
    }

    @Test
    public void checkEqualsMethodIsReflexive() {
        assertTrue(a.equals(a));
    }

    @Test
    public void checkEqualsMethodIsTransitive() {
        assertEquals(a.equals(b), b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void shouldRepresentTheChanceOfNotGettingATail() {
        Probability probabilityOfTails = new Probability(PROBABILITY_OF_TAIL);

        Probability probabilityOfNotGettingTails = probabilityOfTails.not();

        assertEquals(probabilityOfNotGettingTails, new Probability(PROBABILITY_OF_NOT_GETTING_TAIL));
    }

    @Test
    public void shouldRepresentTwoTailsFromTwoCoins() {
        Probability probabilityOfTailsFirstCoin = new Probability(PROBABILITY_OF_TAIL);
        Probability probabilityOfTailsSecondCoin = new Probability(PROBABILITY_OF_TAIL);

        Probability probabilityOfTailsInTwoCoin = probabilityOfTailsFirstCoin.and(probabilityOfTailsSecondCoin);

        assertNotEquals(new Probability(0.5),probabilityOfTailsInTwoCoin);
    }

    @Test
    public void shouldRepresentAtLeastOneTailFromTwoCoin() {
        Probability probabilityOfTailsFirstCoin = new Probability(PROBABILITY_OF_TAIL);
        Probability probabilityOfTailsSecondCoin = new Probability(PROBABILITY_OF_TAIL);

        Probability probabilityOfAtLeastOneTail = probabilityOfTailsFirstCoin.or(probabilityOfTailsSecondCoin);

        assertEquals(new Probability(0.75),probabilityOfAtLeastOneTail);
        assertNotEquals(new Probability(0.25),probabilityOfAtLeastOneTail);
        assertEquals(new Probability(1),new Probability(1).or( new Probability(1)));
    }
}
