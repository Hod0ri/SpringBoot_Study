import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {

    @Mock
    public MarketAPI marketAPI;

    @BeforeEach
    public void init() {
        Mockito.lenient().when(marketAPI.connect()).thenReturn(3000);
    }

    @Test
    public void testHello() {
        System.out.println("Hello");
    }

    @Test
    public void dollarTest() {
        System.out.println("JUnit Study");

        MarketAPI marketAPI = new MarketAPI();

        DollarCalculator dollarCalculator = new DollarCalculator(marketAPI);
        dollarCalculator.init();

        Caculator caculator = new Caculator(dollarCalculator);

        System.out.println(caculator.sum(10, 10));

        Assertions.assertEquals(22000, caculator.sum(10, 10));
        Assertions.assertEquals(0, caculator.minus(10, 10));
    }

    @Test
    public void mockTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(marketAPI);
        dollarCalculator.init();

        Caculator caculator = new Caculator(dollarCalculator);

        System.out.println(caculator.sum(10, 10));

        Assertions.assertEquals(60000, caculator.sum(10, 10));
        Assertions.assertEquals(0, caculator.minus(10, 10));
    }
}
