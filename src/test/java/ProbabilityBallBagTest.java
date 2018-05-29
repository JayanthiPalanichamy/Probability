import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityBallBagTest {
    BallBag ballBag;

    @Before
    public void setUp(){
        ballBag = new BallBag(2,2,1);
    }

    @Test
    public void returnProbabilityOfGettingOneBlueBallAndOneRedBall() {
        Probability probabilityOfOneBlueAndOneRed = ballBag.calculateProbabilityOfGetting(1,0,1);

        assertEquals(probabilityOfOneBlueAndOneRed,new Probability(0.2));
    }

    @Test
    public void returnProbabilityOfGettingTwoBlueBall() {
        Probability probabilityOfOneBlueAndOneRed = ballBag.calculateProbabilityOfGetting(2,0,0);

        assertEquals(probabilityOfOneBlueAndOneRed,new Probability(0.1));
    }
}
