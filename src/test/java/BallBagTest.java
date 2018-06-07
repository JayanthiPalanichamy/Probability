import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BallBagTest {
    BallBag ballBag;
    HashMap<BallColor,Integer> drawnBallList;

    @Before
    public void setUp(){
        HashMap<BallColor,Integer> ballList = new HashMap<>();
        ballList.put(BallColor.BLUE,2);
        ballList.put(BallColor.YELLOW,2);
        ballList.put(BallColor.RED,1);

        ballBag = new BallBag(ballList);
        drawnBallList = new HashMap<>();
    }

    @Test
    public void returnProbabilityOfGettingOneBlueBallAndOneRedBall() {
        drawnBallList.put(BallColor.BLUE,1);
        drawnBallList.put(BallColor.RED,1);
        Probability probabilityOfOneBlueAndOneRed = ballBag.calculateProbabilityOfGettingExactly(drawnBallList);

        assertEquals(new Probability(0.2),probabilityOfOneBlueAndOneRed);
    }

    @Test
    public void returnProbabilityOfGettingTwoBlueBall() {
        drawnBallList.put(BallColor.BLUE,2);
        Probability probabilityOfTwoBlue = ballBag.calculateProbabilityOfGettingExactly(drawnBallList);

        assertEquals(new Probability(0.1),probabilityOfTwoBlue);
    }

    @Test
    public void returnProbabilityOfGettingThreeDistinctColorBalls() {
        drawnBallList.put(BallColor.BLUE,1);
        drawnBallList.put(BallColor.RED,1);
        drawnBallList.put(BallColor.YELLOW,1);
        Probability probabilityOfThreeDistinctColor = ballBag.calculateProbabilityOfGettingExactly(drawnBallList);

        assertEquals(new Probability(0.4),probabilityOfThreeDistinctColor);
    }
}
