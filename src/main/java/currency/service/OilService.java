package currency.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Just to illustrate JSON parsing. Currency data from NBU's service
 * http://www.bank.gov.ua/control/uk/publish/article?art_id=24794511&cat_id=7693080
 *
 * Created by paulvoropaiev on 12/11/15.
 */
public class OilService {

    private static final String APIURL = "http://zenrus.ru/build/js/currents.js";

    public String readUrl() throws Exception {

        BufferedReader reader = null;
        try {
            final URL url = new URL(APIURL);
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
