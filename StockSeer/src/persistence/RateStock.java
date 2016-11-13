package persistence;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.html.parser.DTD;

/**
 * Created by anvu on 11/12/16.
 */

// d=month; e=day; f=year;
// c = end year
// b = end day
// a = end month
// http://ichart.finance.yahoo.com/table.csv?d=6&e=1&f=2009&g=d&a=7&b=19&c=2004&ignore=.csv&s=YHOO
public class RateStock {
    
    public static void main(String[] args) throws IOException {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        Date today = new Date();
        int d = today.get(Date.DAY_OF_MONTH),
                m = today.get(Date.MONTH),
                y = today.get(Date.YEAR);
        String symbol = "YHOO";
    
        ArrayList<Double> prices = new ArrayList<>();
        try {
            String url_string = String.format("http://ichart.finance.yahoo.com/table" +
                    ".csv?d=%1$d&e=%2$d&f=%3$d&g=d&a=%1$d&b=%2$d&c=%4$d&ignore=.csv&s=%5$s", m, d, y, y - 1, symbol);
            url = new URL(url_string);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                prices.add(Double.parseDouble(line.split(",")[1]));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    
        System.out.println(Arrays.toString(prices.toArray()));
    }
}
