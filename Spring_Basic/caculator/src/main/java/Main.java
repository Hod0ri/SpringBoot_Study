public class Main {
    public static void main(String[] args) {
        System.out.println("JUnit Study");

        MarketAPI marketAPI = new MarketAPI();

        DollarCalculator dollarCalculator = new DollarCalculator(marketAPI);
        dollarCalculator.init();

        Caculator caculator = new Caculator(dollarCalculator);

        System.out.println(caculator.sum(10, 10));
    }
}
