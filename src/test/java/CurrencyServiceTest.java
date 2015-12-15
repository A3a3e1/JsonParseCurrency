import currency.service.CurrencyService;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by paulvoropaiev on 12/11/15.
 */
public class CurrencyServiceTest {

    Map<String, Double> list;
    CurrencyService service;

    public CurrencyServiceTest() {
        service = new CurrencyService();
        list = service.getAllCurrencies();
    }


    @Test
    public void listNotNull() {
        assertTrue(list.size()>0);
    }

    @Test
    public void UsdPresent() {
        assertTrue(list.containsKey("\"USD\""));
    }

    @Test
    public void EurPresent() {
        assertTrue(list.containsKey("\"EUR\""));
    }

    @Test
    public void RubPresent() {
        assertTrue(list.containsKey("\"RUB\""));
    }
}
