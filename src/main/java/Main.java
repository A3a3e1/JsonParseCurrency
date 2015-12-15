import currency.service.CurrencyService;
import currency.service.OilService;

public class Main {

    /**
     * Just an example
     * @param args
     */
    public static void main(final String[] args) throws Exception {

        OilService oil = new OilService();
        String js = oil.readUrl();

        js = js.substring(js.length()-6, js.length()-1);

        CurrencyService service = new CurrencyService();
        System.out.println("=================");
        System.out.println("|| Oil: $" + js + " ||");
        System.out.println("|| USD: \u20B4" + service.getRateByShortName("USD") + " ||");
        System.out.println("|| EUR: \u20B4" + service.getRateByShortName("EUR") + " ||");
        System.out.println("=================");
    }

}