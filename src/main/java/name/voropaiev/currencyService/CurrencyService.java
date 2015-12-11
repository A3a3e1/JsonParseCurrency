package name.voropaiev.currencyService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Just to illustrate JSON parsing. Currency data from NBU's service
 * http://www.bank.gov.ua/control/uk/publish/article?art_id=24794511&cat_id=7693080
 *
 * Created by paulvoropaiev on 12/11/15.
 */
public class CurrencyService {

    private static final String APIURL = "http://nbu1.bank.gov.ua/NBUStatService/v1/statdirectory?exchange&json";

    JsonElement element;
    JsonObject object;
    Map<String, Double> wholeList = new HashMap<String, Double>();

    public CurrencyService() {
    try {
        String json = readUrl(APIURL);
        JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
        for (int i=0; i < jsonArray.size(); i++) {
            element = jsonArray.get(i);
            object = element.getAsJsonObject();
            wholeList.put(object.get("cc").toString(), Double.parseDouble(object.get("rate").toString()));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public Map<String, Double> getAllCurrencies() {
        return wholeList;
    }

    public double getRateByShortName(String name) {
        name = "\"" + name + "\""; //because in the source JSON there are " signs
        return wholeList.get(name);
    }

    private static String readUrl(final String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            final URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            final StringBuffer buffer = new StringBuffer();
            int read;
            final char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
