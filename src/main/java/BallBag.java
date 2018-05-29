public class BallBag {
    private final int blueBalls;
    private final int yellowBalls;
    private final int redBalls;
    private final int sample;

    public BallBag(int blueBalls, int yellowBalls, int redBalls) {
        this.blueBalls = blueBalls;
        this.yellowBalls = yellowBalls;
        this.redBalls = redBalls;
        this.sample = blueBalls + yellowBalls + redBalls;
    }

    public Probability calculateProbabilityOfGetting(int blueDrawn, int yellowDrawn, int redDrawn) {
        int totalBallsDrawn = blueDrawn + yellowDrawn + redDrawn;
        return new Probability((nCr(blueBalls, blueDrawn) * nCr(yellowBalls, yellowDrawn) * nCr(redBalls, redDrawn)) / nCr(sample, totalBallsDrawn));
    }

    private double nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    private double fact(int num) {
        if (num == 0 || num == 1) return 1.0;
        double factorialValue = 1.0;
        while (num != 0) {
            factorialValue *= num;
            num--;
        }
        return factorialValue;
    }


}
