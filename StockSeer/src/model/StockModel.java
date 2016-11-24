package model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 */
public class StockModel {
    private String symbol;
    private String name;
    private yahoofinance.Stock stock;
    
    /**
     * @param symbol stock symbol
     */
    public StockModel(String symbol) {
        this.symbol = symbol;
        try {
            stock = YahooFinance.get(symbol);
            name = stock.getName();
        } catch (IOException e) {
            System.err.println("ERROR::Can't create stock object from Yahoo Finance");
            e.printStackTrace();
        }
    }
    
    public BigDecimal getPrice() {
        return stock.getQuote().getPrice();
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * @param obj StockSeer.Model.StockModel object
     * @return true if two StockModel objects have same symbols
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        StockModel compareObj = (StockModel) obj;
        return Objects.equals(this.getSymbol(), compareObj.getSymbol());
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(23, 31).append(symbol).toHashCode();
    }

//    public static void main(String[] args) {
//        Stock stock = null;
//        try {
//            stock = YahooFinance.get("SSNLF");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        BigDecimal price = stock.getQuote().getPrice();
//        BigDecimal change = stock.getQuote().getChangeInPercent();
//        BigDecimal peg = stock.getStats().getPeg();
//        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
//        stock.print();
//        System.out.println(stock.getName());
//    }
}
