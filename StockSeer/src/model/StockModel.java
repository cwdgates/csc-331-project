package model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

public class StockModel {
    private double price;
    private String symbol;
    private String name;
    private String currency;
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
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
}
