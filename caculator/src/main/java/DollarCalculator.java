public class DollarCalculator implements ICalculator{

    private int price = 1;

    private MarketAPI marketapi;

    public DollarCalculator(MarketAPI marketapi) {
        this.marketapi = marketapi;
    }

    public void init() {
        this.price = marketapi.connect();
    }

    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
