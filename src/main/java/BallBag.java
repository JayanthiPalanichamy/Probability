import java.util.HashMap;

public class BallBag {
    private final int sample;
    private HashMap<BallColor, Integer> ballList;
    public BallBag(HashMap<BallColor, Integer> ballList) {
        this.ballList = ballList;
        sample = ballList.values().stream().reduce(0 ,(a,b)->a+b);
    }

    public Probability calculateProbabilityOfGettingExactly(HashMap<BallColor, Integer> drawnBallList) {
        int totalBallsDrawn = drawnBallList.values().stream().reduce(0 ,(a,b)->a+b);
        double value = 1;
        for (BallColor ballColor:drawnBallList.keySet()) {
            value *=  nCr(ballList.get(ballColor),drawnBallList.get(ballColor));

        }
        value = value/ nCr(sample, totalBallsDrawn);
        return new Probability( value);
    }

    private double nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private double factorial(int number) {
        if (number == 0 || number == 1) return 1.0;
        double factorialValue = 1.0;
        while (number != 0) {
            factorialValue *= number;
            number--;
        }
        return factorialValue;
    }


}
