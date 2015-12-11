import name.voropaiev.currencyService.CurrencyService;

public class Main {

    /**
     * Just an example
     * @param args
     */
    public static void main(final String[] args) {

        CurrencyService service = new CurrencyService();
        System.out.println("USD: " + service.getRateByShortName("USD"));
        System.out.println("EUR: " + service.getRateByShortName("EUR"));
    }

}