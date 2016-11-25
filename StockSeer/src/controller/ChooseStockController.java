package controller;

import model.StockModel;
import persistence.StockUtility;
import view.ChooseStockPane;
import view.LeagueCreationPane;
import view.renderModel.AvailableStockModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aqv on 11/24/2016.
 */
public class ChooseStockController implements ActionListener {
    LeagueCreationPane leagueCreationPane;
    
    public ChooseStockController(LeagueCreationPane leagueCreationPane) {
        this.leagueCreationPane = leagueCreationPane;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case LeagueCreationPane.BTN_CHOOSE_STOCK: {
                ChooseStockPane chooseStockPane = ChooseStockPane.showChooseStockPane();
                chooseStockPane.registerController(e1 -> {
                    String command1 = e1.getActionCommand();
                    String[] stocks = null;
                    
                    switch (command1) {
                        case ChooseStockPane.BTN_ACCEPT: {
                            if (stocks != null) {
                                leagueCreationPane.setStocks(stocks);
                            } else {
                                System.err.println("WARNING::Stocks array is null");
                            }
                            leagueCreationPane.setBtnCreateEnabled(true);
                            chooseStockPane.setVisible(false);
                            break;
                        }
                        case ChooseStockPane.BTN_REROLL: {
                            stocks = StockUtility.getStocksForLeague(leagueCreationPane.getDifficulty(),
                                    leagueCreationPane.getCapacity());
                            AvailableStockModel availableStockModel = new AvailableStockModel();
                            availableStockModel.setData(stocks);
                            chooseStockPane.setAvailStockModel(availableStockModel);
                            
                            chooseStockPane.setBtnAcceptEnabled(true);
                            break;
                        }
                        default:
                            break;
                    }
                });
                
                break;
            }
            default:
                break;
        }
    }
}
