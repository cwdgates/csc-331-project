package model;

import java.util.ArrayList;

/**
 * Created by anvu on 11/22/16.
 */
public class OtherPlayerModel {
    private String username;
    private ArrayList<StockModel> ownedStocks;
    
    public OtherPlayerModel(String username) {
        this.username = username;
        ownedStocks = new ArrayList<>();
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setOwnedStocks(ArrayList<StockModel> ownedStocks) {
        this.ownedStocks = ownedStocks;
    }
}