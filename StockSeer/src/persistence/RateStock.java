package persistence;

import model.Date;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

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
        System.out.println(rateStock(stockPrices52w("AMD")));
    }
    
    public static double[] stockPrices52w(String symbol) throws IOException {
        
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        Date today = new Date();
        int d = today.get(Date.DAY_OF_MONTH),
                m = today.get(Date.MONTH),
                y = today.get(Date.YEAR);
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
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        
        double[] prices_d = new double[prices.size()];
        for (int i = 0; i < prices.size(); i++) {
            prices_d[i] = prices.get(i);
        }
        return prices_d;
    }
    
    public static double rateStock(double[] prices) {
        
        ArrayList<Double> belowNeg20 = new ArrayList<>();
        ArrayList<Double> _Neg20to15 = new ArrayList<>();
        ArrayList<Double> _Neg15to10 = new ArrayList<>();
        ArrayList<Double> _Neg10to5 = new ArrayList<>();
        ArrayList<Double> _Neg5to0 = new ArrayList<>();
        
        ArrayList<Double> _0to5 = new ArrayList<>();
        ArrayList<Double> _5to10 = new ArrayList<>();
        ArrayList<Double> _10to15 = new ArrayList<>();
        ArrayList<Double> _15to20 = new ArrayList<>();
        ArrayList<Double> _above20 = new ArrayList<>();
        
        for (int i = 1; i < prices.length; i++) {
            Double difference = (prices[i] / prices[i-1] - 1) * 100.0;
            if (difference < -20.0) {
                belowNeg20.add(difference);
            } else if (difference >= -20.0 && difference < -15.0) {
                _Neg20to15.add(difference);
            } else if (difference >= -15 && difference < -10) {
                _Neg15to10.add(difference);
            } else if (difference >= -10 && difference < -5) {
                _Neg10to5.add(difference);
            } else if (difference >= -5 && difference < 0) {
                _Neg5to0.add(difference);
            } else if (difference >= 0 && difference < 5) {
                _0to5.add(difference);
            } else if (difference >= 5 && difference < 10) {
                _5to10.add(difference);
            } else if (difference >= 10 && difference < 15) {
                _10to15.add(difference);
            } else if (difference >= 15 && difference < 20) {
                _15to20.add(difference);
            } else {
                _above20.add(difference);
            }
        }
        
        
        // find median
        double medBelowNeg20 = median(belowNeg20);
        double medNeg20to15 = median(_Neg20to15);
        double medNeg15to10 = median(_Neg15to10);
        double medNeg10to5 = median(_Neg10to5);
        double medNeg5to0 = median(_Neg5to0);
        double med0to5 = median(_0to5);
        double med5to10 = median(_5to10);
        double med10to15 = median(_10to15);
        double med15to20 = median(_15to20);
        double medAbove20 = median(_above20);
        
        int totalNegative = belowNeg20.size() + _Neg5to0.size() + _Neg10to5.size() + _Neg15to10.size() +
                _Neg20to15.size();
        
        int totalPositive = _above20.size() + _15to20.size() + _10to15.size() + _5to10.size() + _0to5.size();
        
        medBelowNeg20 = medBelowNeg20 * belowNeg20.size() / totalNegative;
        medNeg20to15 = medNeg20to15 * _Neg20to15.size() / totalNegative;
        medNeg15to10 = medNeg15to10 * _Neg15to10.size() / totalNegative;
        medNeg10to5 = medNeg10to5 * _Neg10to5.size() / totalNegative;
        medNeg5to0 = medNeg5to0 * _Neg5to0.size() / totalNegative;
        med0to5 = med0to5 * _0to5.size() / totalPositive;
        med5to10 = med5to10 * _5to10.size() / totalPositive;
        med10to15 = med10to15 * _10to15.size() / totalPositive;
        med15to20 = med15to20 * _15to20.size() / totalPositive;
        medAbove20 = medAbove20 * _above20.size() / totalPositive;
        
        double positive = med0to5 + med5to10 + med10to15 + med15to20 + medAbove20;
        double negative = medBelowNeg20 + medNeg20to15 + medNeg15to10 + medNeg10to5 + medNeg5to0;
        
        System.out.println("total positive" + totalPositive);
        System.out.println("total negative" + totalNegative);

        System.out.println(positive);
        System.out.println(negative);
        
        return positive >= Math.abs(negative) ? positive : negative;
    }
    
    private static double median(ArrayList<Double> array) {
        if (array.size() == 0) {
            return 0;
        }
        double[] numArray = new double[array.size()];
        
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = array.get(i);
        }
        
        Arrays.sort(numArray);
        double median;
        if (numArray.length % 2 == 0)
            median = (numArray[numArray.length / 2] + numArray[numArray.length / 2 - 1]) / 2;
        else
            median = numArray[numArray.length / 2];
        
        return median;
    }
}

